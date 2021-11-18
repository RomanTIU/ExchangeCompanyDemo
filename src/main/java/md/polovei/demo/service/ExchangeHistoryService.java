package md.polovei.demo.service;

import md.polovei.demo.models.ExchangeHistory;
import md.polovei.demo.models.ExchangeSection;
import md.polovei.demo.repository.ExchangeHistoryRepository;
import md.polovei.demo.repository.ExchangeSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExchangeHistoryService {
    @Autowired
    ExchangeHistoryRepository repository;

    public void createUpdateEmployee(ExchangeHistory exchange) {
        repository.save(exchange);
    }

    public Iterable<ExchangeHistory> getAll() {
        return repository.findAll();
    }

    public Optional<ExchangeHistory> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
