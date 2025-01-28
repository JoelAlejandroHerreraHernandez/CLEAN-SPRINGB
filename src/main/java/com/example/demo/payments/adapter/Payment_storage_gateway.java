package com.example.demo.payments.adapter;

import com.example.demo.payments.entities.Payment;
import com.example.demo.payments.use_cases.ports.Payment_repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class Payment_storage_gateway implements Payment_repository {

    private Payment_gateway gateway;

    @Override
    public List<Payment> getAll() {
        return gateway.findAll();
    }

    @Override
    public Payment save(Payment payment) {
        return gateway.save(payment);
    }
}
