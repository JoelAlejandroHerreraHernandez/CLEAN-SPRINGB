package com.example.demo.products.application.usecases;

import com.example.demo.products.domain.entity.Product;
import com.example.demo.products.domain.entity.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class GetProductInteractor {

    private final ProductRepository productRepository;

    public List<Product> execute() {
        return productRepository.findAll();
    }
}