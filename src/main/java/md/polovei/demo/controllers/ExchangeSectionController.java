package md.polovei.demo.controllers;

import md.polovei.demo.service.ExchangeSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exSection")
public class ExchangeSectionController {

    @Autowired
    ExchangeSectionService exchangeSectionService;

    @GetMapping("")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(exchangeSectionService.getAll());
    }
}
