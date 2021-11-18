package md.polovei.demo.controllers;

import md.polovei.demo.models.ExchangeHistory;
import md.polovei.demo.service.CurrencyDictionaryService;
import md.polovei.demo.service.EmployeeService;
import md.polovei.demo.service.ExchangeHistoryService;
import md.polovei.demo.service.ExchangeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exHistory")
public class ExchangeHistoryController {

    @Autowired
    ExchangeHistoryService exchangeHistoryService;
    @Autowired
    CurrencyDictionaryService currencyDictionaryService;
    @Autowired
    ExchangeService exchangeService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity create(@RequestBody String body) {
        if (!body.isEmpty()) {

            JSONObject jsonObject = new JSONObject(body);
            String cMain = jsonObject.getString("currencyIn");
            String cSec = jsonObject.getString("currencyOut");
            ExchangeHistory exchangeHistory = new ExchangeHistory();

            if (currencyDictionaryService.getById(cMain).isPresent()
                    && currencyDictionaryService.getById(cSec).isPresent()
                    && exchangeService.getById(jsonObject.getLong("exchange")).isPresent()
                    && employeeService.getById(jsonObject.getLong("employee")).isPresent()) {
                exchangeHistory.setCurrencyIn(currencyDictionaryService.getById(cMain).get());
                exchangeHistory.setCurrencyOut(currencyDictionaryService.getById(cSec).get());
                exchangeHistory.setEmployee(employeeService.getById(jsonObject.getLong("employee")).get());
                exchangeHistory.setExchange(exchangeService.getById(jsonObject.getLong("exchange")).get());
            }
            exchangeHistory.setSumIn(jsonObject.getDouble("sumIn"));
            exchangeHistory.setSumOut(
                    exchangeHistory.getSumIn()
                            * exchangeHistory.getExchange().getPrice()
                            / exchangeHistory.getExchange().getRate());
            exchangeHistoryService.createUpdateEmployee(exchangeHistory);
            return ResponseEntity.ok().body("Created successful");
        } else {
            return ResponseEntity.status(422).body("Body is empty");
        }
    }
}
