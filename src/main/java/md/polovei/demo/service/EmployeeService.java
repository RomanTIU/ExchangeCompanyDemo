package md.polovei.demo.service;

import md.polovei.demo.models.Employee;
import md.polovei.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public void createUpdateEmployee(Employee employee) {
        repository.save(employee);
    }

    public Iterable<Employee> getEmployee() {
        return repository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
