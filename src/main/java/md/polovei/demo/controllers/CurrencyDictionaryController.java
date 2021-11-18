package md.polovei.demo.controllers;

import md.polovei.demo.models.CurrencyDictionary;
import md.polovei.demo.service.CurrencyDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.util.Optional;

@RestController
@RequestMapping("/api/currency")
public class CurrencyDictionaryController {

    @Autowired
    CurrencyDictionaryService currencyDictionaryService;

    @GetMapping("")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(currencyDictionaryService.getCurrency());
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody CurrencyDictionary currencyDictionary) {
        if (currencyDictionary != null) {
            currencyDictionaryService.createUpdateCurrency(currencyDictionary);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(422).body("Not found by this ID or object is null");
        }
    }

    @PutMapping("")
    public ResponseEntity update(@RequestBody CurrencyDictionary currencyDictionary) {
        if (currencyDictionary != null && !currencyDictionary.getCurrency_code().isEmpty()) {
            Optional<CurrencyDictionary> currency =
                    currencyDictionaryService.getById(currencyDictionary.getCurrency_code());
            currency.ifPresent(value -> value = currencyDictionary);
            currencyDictionaryService.createUpdateCurrency(currency.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(422).body("Not found by this ID or object is null");
        }
    }
}