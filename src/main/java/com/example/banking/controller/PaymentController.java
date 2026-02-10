package com.example.banking.controller;

import com.example.banking.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/accept")
    public String acceptPayment(
            @RequestParam String name,
            @RequestParam double amount,
            @RequestParam String mode) {

        service.acceptPayment(name, amount, mode);
        return "Payment successful";
    }

    @GetMapping("/balance")
    public double getBalance(@RequestParam String name) {
        return service.getBalance(name);
    }
}
