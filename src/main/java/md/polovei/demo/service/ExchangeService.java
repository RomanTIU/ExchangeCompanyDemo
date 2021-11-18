package md.polovei.demo.service;

import md.polovei.demo.models.Exchange;
import md.polovei.demo.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExchangeService {

    @Autowired
    ExchangeRepository repository;

    public void createUpdateExchange(Exchange exchange) {
        repository.save(exchange);
    }

    public Iterable<Exchange> getExchanges() {
        return repository.findAll();
    }

    public Optional<Exchange> getById(Long id) {
        return repository.findById(id);
    }

    public Optional<Exchange> getByCode(String code) {
        return repository.findAll().stream()
                .filter(f -> f.getCurrencyMain().getCurrency_code().equals(code))
                .findFirst();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
