package md.polovei.demo.controllers;

import md.polovei.demo.models.Exchange;
import md.polovei.demo.service.CurrencyDictionaryService;
import md.polovei.demo.service.ExchangeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;
    @Autowired
    CurrencyDictionaryService currencyDictionaryService;

    @GetMapping("")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(exchangeService.getExchanges());
    }

    @GetMapping("{code}")
    public ResponseEntity getByCode(@PathVariable("code") String code) {
        if (!code.isEmpty() && exchangeService.getByCode(code).isPresent()) {
            return ResponseEntity.ok(exchangeService.getByCode(code));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody String exchange) throws ParseException {
        if (exchange != null) {

            JSONObject jsonObject = new JSONObject(exchange);
            String cMain = jsonObject.getString("currencyMain");
            String cSec = jsonObject.getString("currencySec");
            Exchange exchange1 = new Exchange();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            if (currencyDictionaryService.getById(cMain).isPresent()
                    && currencyDictionaryService.getById(cSec).isPresent()) {
                exchange1.setCurrencyMain(currencyDictionaryService.getById(cMain).get());
                exchange1.setCurrencySec(currencyDictionaryService.getById(cSec).get());
                exchange1.setExchangeDate(formatter.parse(jsonObject.getString("exchangeDate")));
            } else {
                return ResponseEntity.status(422).body("Don`t exist currency with this code");
            }
            exchange1.setPrice(jsonObject.getDouble("price"));
            exchange1.setRate(jsonObject.getLong("rate"));
            exchangeService.createUpdateExchange(exchange1);
            return ResponseEntity.ok().body("Successful create");
        } else {
            return ResponseEntity.status(422).body("Object is null");
        }
    }
}
