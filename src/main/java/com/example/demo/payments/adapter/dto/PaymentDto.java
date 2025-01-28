package com.example.demo.payments.adapter.dto;

import com.example.demo.payments.entities.Payment;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentDto {

    @NotNull(groups = {Modify.class})
    @Min(value = 1, groups = {Modify.class})
    @Max(value = 1000000, groups = {Modify.class})
    private int id;

    @NotBlank(groups = {Save.class})
    @Length(min = 5, max = 100, groups = {Save.class})
    private String description;

    @NotNull(groups = {Save.class})
    @Min(value = 1, groups = {Save.class})
    @Max(value = 1000000, groups = {Save.class})
    private double amount;

    public interface Modify {}
    public interface Save {}

    public Payment toPayment(){
        return new Payment(this.id, this.description, this.amount);
    }
}
