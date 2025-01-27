package com.example.demo.products.domain.entity;

import java.util.List;

public interface ProductRepository {

    /**
     * Definw los métodos que se pueden realizar sobre la entidad
     */
    Product save(Product product);
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
}
