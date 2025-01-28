package com.example.demo.payments.use_cases;

import com.example.demo.kernel.UseCase;
import com.example.demo.payments.entities.Payment;
import com.example.demo.payments.use_cases.ports.Payment_repository;
import jakarta.annotation.Nullable;

import java.util.List;

public class GetPayments_interactor implements UseCase<Void, List<Payment>> {

    private final Payment_repository repository;
    public GetPayments_interactor(Payment_repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> execute(@Nullable Void payload, @Nullable Void payloadToken) {
        return repository.getAll();
    }
}
