package com.example.demo.payments.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Document(collection = "payments")
public class Payment {

    @Id
    private int id;
    private String description;
    private double amount;
}
