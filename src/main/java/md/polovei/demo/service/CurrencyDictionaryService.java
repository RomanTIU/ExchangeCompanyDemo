package md.polovei.demo.service;

import md.polovei.demo.models.CurrencyDictionary;
import md.polovei.demo.models.EmployeeFunction;
import md.polovei.demo.repository.CurrencyDictionaryRepository;
import md.polovei.demo.repository.EmployeeFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyDictionaryService {
    @Autowired
    CurrencyDictionaryRepository repository;

    public void createUpdateCurrency(CurrencyDictionary currencyDictionary) {
        repository.save(currencyDictionary);
    }

    public Iterable<CurrencyDictionary> getCurrency() {
        return repository.findAll();
    }

    public Optional<CurrencyDictionary> getById(String code) {
        return repository.findAll().stream().filter(f -> f.getCurrency_code().equals(code)).findFirst();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
