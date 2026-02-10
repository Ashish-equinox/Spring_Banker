package com.example.banking.dao;

import com.example.banking.db.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("upi")
public class UPIDAO implements PaymentDAO {

    @Autowired
    private InMemoryDatabase db;

    @Override
    public void acceptPayment(String name, double amount) {
        db.credit(name, amount); // NO deduction for UPI
    }

    @Override
    public double getBalance(String name) {
        return db.getBalance(name);
    }
}
