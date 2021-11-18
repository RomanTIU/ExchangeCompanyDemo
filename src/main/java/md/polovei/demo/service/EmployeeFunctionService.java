package md.polovei.demo.service;

import md.polovei.demo.models.EmployeeFunction;
import md.polovei.demo.repository.EmployeeFunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeFunctionService {
    @Autowired
    EmployeeFunctionRepository repository;

    public void createUpdateEmployeeFunction(EmployeeFunction employeeFunction) {
        repository.save(employeeFunction);
    }

    public Iterable<EmployeeFunction> getEmployeeFunction() {
        return repository.findAll();
    }

    public Optional<EmployeeFunction> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
