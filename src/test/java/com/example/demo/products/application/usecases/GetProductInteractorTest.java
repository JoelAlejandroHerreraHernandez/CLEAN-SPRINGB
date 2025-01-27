package com.example.demo.products.application.usecases;

import com.example.demo.products.domain.entity.Product;
import com.example.demo.products.domain.entity.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GetProductInteractorTest {

    private ProductRepository productRepository;
    private GetProductInteractor getProductInteractor;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        getProductInteractor = new GetProductInteractor(productRepository);
    }

    @Test
    void testExecuteReturnsProductList() {
        // Arrange: Lista de productos simulada
        Product product1 = new Product("1", "Laptop", "Gaming laptop", 1500.00);
        Product product2 = new Product("2", "Mouse", "Wireless mouse", 50.00);
        List<Product> expectedProducts = Arrays.asList(product1, product2);

        when(productRepository.findAll()).thenReturn(expectedProducts);

        // Act: Llamar al método execute
        List<Product> actualProducts = getProductInteractor.execute();

        // Assert: Verificar los resultados
        assertThat(actualProducts).isNotNull();
        assertThat(actualProducts).hasSize(2);
        assertThat(actualProducts).containsExactly(product1, product2);

        // Verificar que el método findAll() se llamó una vez
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testExecuteReturnsEmptyListWhenNoProducts() {
        // Arrange: Repositorio devuelve lista vacía
        when(productRepository.findAll()).thenReturn(List.of());

        // Act: Ejecutar el método
        List<Product> actualProducts = getProductInteractor.execute();

        // Assert: Verificar lista vacía
        assertThat(actualProducts).isNotNull().isEmpty();

        // Verificar que findAll() se llamó una vez
        verify(productRepository, times(1)).findAll();
    }
}
