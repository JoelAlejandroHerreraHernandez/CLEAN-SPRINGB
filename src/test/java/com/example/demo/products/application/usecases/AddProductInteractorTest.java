package com.example.demo.products.application.usecases;

import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.products.application.dto.AddProductDTO;
import com.example.demo.products.domain.entity.Product;
import com.example.demo.products.domain.entity.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AddProductInteractorTest {

    private ProductRepository productRepository;
    private AddProductInteractor addProductInteractor;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        addProductInteractor = new AddProductInteractor(productRepository);
    }

    @Test
    void testExecuteShouldSaveProductSuccessfully() {
        // Arrange: Crear DTO de entrada
        AddProductDTO addProductDTO = new AddProductDTO("Mouse", "Wireless mouse", 29.99);
        Product expectedProduct = new Product("1", "Mouse", "Wireless mouse", 29.99);

        when(productRepository.save(any(Product.class))).thenReturn(expectedProduct);

        // Act: Ejecutar el método
        Product savedProduct = addProductInteractor.execute(addProductDTO);

        // Assert: Verificar los resultados
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isEqualTo("1");
        assertThat(savedProduct.getName()).isEqualTo("Mouse");
        assertThat(savedProduct.getPrice()).isEqualTo(29.99);
        assertThat(savedProduct.getDescription()).isEqualTo("Wireless mouse");

        // Verificar que el método save fue llamado con los datos correctos
        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository, times(1)).save(productCaptor.capture());

        Product capturedProduct = productCaptor.getValue();
        assertThat(capturedProduct.getName()).isEqualTo("Mouse");
        assertThat(capturedProduct.getDescription()).isEqualTo("Wireless mouse");
        assertThat(capturedProduct.getPrice()).isEqualTo(29.99);
    }

    @Test
    void testExecuteWithInvalidData() {
        // Arrange: DTO con valores nulos
        AddProductDTO invalidDTO = new AddProductDTO(null, null, 0.0);
        Product defaultProduct = new Product("1", null, null, 0.0);

        // Simular que el repositorio devuelve un producto válido aunque los datos de entrada sean incorrectos
        when(productRepository.save(any(Product.class))).thenReturn(defaultProduct);

        // Act: Ejecutar el método
        Product result = addProductInteractor.execute(invalidDTO);

        // Assert: Verificar que se guardó un producto con valores nulos o por defecto
        assertThat(result).isNotNull();
        assertThat(result.getName()).isNull();
        assertThat(result.getDescription()).isNull();
        assertThat(result.getPrice()).isEqualTo(0.0);

        // Verificar que el método save fue llamado
        verify(productRepository, times(1)).save(any(Product.class));
    }
}
