package com.example.demo.products.application;

import com.example.demo.products.application.dto.AddProductDTO;
import com.example.demo.products.application.usecases.AddProductInteractor;
import com.example.demo.products.application.usecases.GetProductInteractor;
import com.example.demo.products.domain.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final GetProductInteractor getProductInteractor;
    private final AddProductInteractor addProductInteractor;

    /**
     * Aplique el principio de inversión de dependencias y responsabilidad unica en el método.
     * Aplica el caso de uso necesario
     */

    public List<Product> getAllProducts() {
        return getProductInteractor.execute();
    }

    public Product addProduct(AddProductDTO addProductDTO) {
        return addProductInteractor.execute(addProductDTO);
    }
}
