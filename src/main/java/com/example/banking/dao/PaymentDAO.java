package com.example.banking.dao;

public interface PaymentDAO {
    void acceptPayment(String name, double amount);
    double getBalance(String name);
}
