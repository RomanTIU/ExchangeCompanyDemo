package md.polovei.demo.service;

import md.polovei.demo.models.Report;
import md.polovei.demo.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportRepository repository;

    public void createUpdateReport(Report report) {
        repository.save(report);
    }

    public Iterable<Report> getAll() {
        return repository.findAll();
    }

    public Optional<Report> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
