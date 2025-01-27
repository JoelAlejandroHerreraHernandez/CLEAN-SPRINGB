package com.example.demo.products.adapter.controller;

import com.example.demo.products.application.ProductService;
import com.example.demo.products.application.dto.AddProductDTO;
import com.example.demo.products.domain.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
public class ProductController {

    /**
     * Recibe las peticiones HTTP y delega la lógica de negocio a la clase ProductService.
     */

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody AddProductDTO addProductDTO) {
        return productService.addProduct(addProductDTO);
    }

}
