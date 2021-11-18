package md.polovei.demo.controllers;

import md.polovei.demo.models.CashIn;
import md.polovei.demo.service.CashInService;
import md.polovei.demo.service.CurrencyDictionaryService;
import md.polovei.demo.service.EmployeeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@RestController
@RequestMapping("/api/cashIn")
public class CashInController {

    @Autowired
    CashInService cashInService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CurrencyDictionaryService currencyDictionaryService;

    @GetMapping("")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(cashInService.getAll());
    }

    @PutMapping("")
    public ResponseEntity updateCashIn(@RequestBody String cashIn) throws ParseException {
        if (cashIn != null) {

            JSONObject jsonObject = new JSONObject(cashIn);
            CashIn cash = cashInService.getById(jsonObject.getLong("id")).get();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            if (employeeService.getById(jsonObject.getLong("employee")).isPresent()
            && currencyDictionaryService.getById(jsonObject.getString("currency")).isPresent()){
                cash.setEmployee(employeeService.getById(jsonObject.getLong("employee")).get());
                cash.setCurrency(currencyDictionaryService.getById(jsonObject.getString("currency")).get());
                cash.setInDate(formatter.parse(jsonObject.getString("inDate")));
                cash.setSum(jsonObject.getDouble("sum"));
            }
            cashInService.createUpdateCashIn(cash);
            return ResponseEntity.ok().body("Successful Update");
        } else {
            return ResponseEntity.status(422).body("Object is null");
        }
    }

    @PostMapping("")
    public ResponseEntity createCashIn(@RequestBody CashIn cashIn) {
        if (cashIn != null) {
            return ResponseEntity.ok().body("Not implemented");
        } else {
            return ResponseEntity.status(422).body("Not found by this ID or object is null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCashIn(@PathVariable("id") Long id) {

        if (cashInService.getById(id).isPresent()) {
            cashInService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(422).body("Not found by this ID");
        }
    }
}
