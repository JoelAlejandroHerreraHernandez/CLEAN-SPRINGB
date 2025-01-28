package com.example.demo.payments.use_cases.ports;

import com.example.demo.payments.entities.Payment;

import java.util.List;

public interface Payment_repository {
    List<Payment> getAll();
    Payment save(Payment payment);
}
