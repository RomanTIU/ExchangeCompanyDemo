package md.polovei.demo.service;

import md.polovei.demo.models.ExchangeSection;
import md.polovei.demo.repository.ExchangeSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeSectionService {
    @Autowired
    ExchangeSectionRepository repository;

    public void createUpdateExchangeSection(ExchangeSection exchange) {
        repository.save(exchange);
    }

    public Iterable<ExchangeSection> getAll() {
        return repository.findAll();
    }

    public Optional<ExchangeSection> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
