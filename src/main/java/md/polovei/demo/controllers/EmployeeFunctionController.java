package md.polovei.demo.controllers;

import md.polovei.demo.service.EmployeeFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/function")
public class EmployeeFunctionController {

    @Autowired
    EmployeeFunctionService service;

    @GetMapping("")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(service.getEmployeeFunction());
    }
}
