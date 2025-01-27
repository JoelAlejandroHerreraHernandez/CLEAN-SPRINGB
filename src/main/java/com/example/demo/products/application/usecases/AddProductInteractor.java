package com.example.demo.products.application.usecases;

import com.example.demo.products.application.dto.AddProductDTO;
import com.example.demo.products.domain.entity.Product;
import com.example.demo.products.domain.entity.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import static org.junit.jupiter.api.Assertions.assertEquals;


@AllArgsConstructor
@Service
@Transactional
public class AddProductInteractor {

    private final ProductRepository productRepository;


    /**
     * En este caso, la interfaz ProductRepository es inyectada en el interactor
     * y Spring Boot automáticamente proporciona la implementación usando MongoProductRepository
     */

    /**
     * Valida los datos de entrada
     * Aplica las reglas de negocio
     * LLama al repositorio para la persistencia
     */

    public Product execute(AddProductDTO addProductDTO) {
        Product product = new Product();
        product.setName(addProductDTO.getName());
        product.setPrice(addProductDTO.getPrice());
        product.setDescription(addProductDTO.getDescription());
        return productRepository.save(product);
    }
}
