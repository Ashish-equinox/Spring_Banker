package com.example.banking.dao;

import com.example.banking.db.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cash")
public class CASHDAO implements PaymentDAO {

    @Autowired
    private InMemoryDatabase db;

    @Override
    public void acceptPayment(String name, double amount) {
        double credited = amount * 0.82; // 18% tax
        db.credit(name, credited);
    }

    @Override
    public double getBalance(String name) {
        return db.getBalance(name);
    }
}
