package com.example.demo.products.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDTO {

    @NotNull(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @NotBlank(message = "Price is required")
    @NotEmpty(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    private Double price;

}