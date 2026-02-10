package com.example.banking.service;

import com.example.banking.dao.PaymentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    @Qualifier("upi")
    private PaymentDAO upiDAO;

    @Autowired
    @Qualifier("cash")
    private PaymentDAO cashDAO;

    public void acceptPayment(String name, double amount, String mode) {

        name = name.trim();
        mode = mode.trim();

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (mode.equalsIgnoreCase("UPI")) {
            upiDAO.acceptPayment(name, amount);
        } else if (mode.equalsIgnoreCase("CASH")) {
            cashDAO.acceptPayment(name, amount);
        } else {
            throw new IllegalArgumentException("Invalid payment mode");
        }
    }

    public double getBalance(String name) {
        return upiDAO.getBalance(name.trim());
    }
}
