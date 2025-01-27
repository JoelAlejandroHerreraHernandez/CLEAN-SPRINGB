package com.example.demo.products.adapter.repository;


import com.example.demo.products.domain.entity.Product;
import com.example.demo.products.domain.entity.ProductRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoProductRepository extends MongoRepository<Product, String>, ProductRepository {


    /**
     * Implemeta la interfaz de repositorio
     */

    @Override
    List<Product> findAll();
}
