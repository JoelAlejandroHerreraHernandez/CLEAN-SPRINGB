package com.example.demo.payments.adapter;

import com.example.demo.payments.entities.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Payment_gateway extends MongoRepository<Payment, String> {

}
