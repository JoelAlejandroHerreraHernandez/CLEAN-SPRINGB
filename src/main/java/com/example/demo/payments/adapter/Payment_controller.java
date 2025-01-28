package com.example.demo.payments.adapter;

import com.example.demo.payments.adapter.dto.PaymentDto;
import com.example.demo.payments.entities.Payment;
import com.example.demo.payments.use_cases.GetPayments_interactor;
import com.example.demo.payments.use_cases.SavePayment_interactor;
import com.example.demo.payments.use_cases.ports.Payment_repository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = {"*"})
public class Payment_controller {

    private final Payment_storage_gateway storageGateway;

    @GetMapping("/")
    public List<Payment> getAllPayments(){
        Payment_repository repository = storageGateway;
        GetPayments_interactor interactor = new GetPayments_interactor(repository);
        return interactor.execute(null, null);
    }

    @PostMapping("/")
    public Payment createPayment(@RequestBody @Validated(PaymentDto.Save.class) PaymentDto payment){
        SavePayment_interactor interactor = new SavePayment_interactor(storageGateway);
        return interactor.execute(payment.toPayment(), null);
    }
}
