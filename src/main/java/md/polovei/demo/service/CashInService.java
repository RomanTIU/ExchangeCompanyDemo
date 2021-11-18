package md.polovei.demo.service;

import md.polovei.demo.models.CashIn;
import md.polovei.demo.repository.CashInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashInService {

    @Autowired
    CashInRepository cashInRepository;

    public void createUpdateCashIn(CashIn cashIn) {
        cashInRepository.save(cashIn);
    }
    public Iterable<CashIn> getAll() {
        return cashInRepository.findAll();
    }
    public Optional<CashIn> getById(Long id) {
        return cashInRepository.findById(id);
    }
    public void deleteById(Long id) {
        cashInRepository.deleteById(id);
    }
}
