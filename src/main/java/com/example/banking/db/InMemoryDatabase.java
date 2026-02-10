package com.example.banking.db;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryDatabase {

    private final Map<String, Double> bank = new ConcurrentHashMap<>();

    public void credit(String name, double amount) {
        name = name.trim(); // SAFETY
        bank.merge(name, amount, Double::sum);
    }

    public double getBalance(String name) {
        name = name.trim(); // SAFETY
        return bank.getOrDefault(name, 0.0);
    }
}
