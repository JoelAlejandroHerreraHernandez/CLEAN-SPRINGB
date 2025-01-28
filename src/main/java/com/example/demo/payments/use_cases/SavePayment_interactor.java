package com.example.demo.payments.use_cases;

import com.example.demo.kernel.UseCase;
import com.example.demo.payments.entities.Payment;
import com.example.demo.payments.use_cases.ports.Payment_repository;

public class SavePayment_interactor implements UseCase<Payment, Payment> {

    private final Payment_repository repository;

    public SavePayment_interactor(Payment_repository repository) {
        this.repository = repository;
    }

    @Override
    public Payment execute(Payment payload, Payment payloadToken) {
        return repository.save(payload);
    }
}
