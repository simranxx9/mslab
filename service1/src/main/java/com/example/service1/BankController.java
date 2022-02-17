package com.example.service1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RequestMapping("/banks")
@RestController
public class BankController {
    private List<Bank> Banks = Arrays.asList(
            new Bank(1, "Joe Bloggs"),
            new Bank(2, "Jane Doe"));
    
    @GetMapping
    public List<Bank> getAllBanks() {
        return Banks;
    }
    
    @GetMapping("/{id}")
    public Bank getBankById(@PathVariable int id) {
        return Banks.stream()
                        .filter(Bank -> Bank.getId() == id)
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
    }
}
