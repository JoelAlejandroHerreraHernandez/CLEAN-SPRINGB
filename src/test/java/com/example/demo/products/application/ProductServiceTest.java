package com.example.demo.products.application;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.products.application.dto.AddProductDTO;
import com.example.demo.products.application.usecases.AddProductInteractor;
import com.example.demo.products.application.usecases.GetProductInteractor;
import com.example.demo.products.domain.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    private GetProductInteractor getProductInteractor;
    private AddProductInteractor addProductInteractor;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        getProductInteractor = Mockito.mock(GetProductInteractor.class);
        addProductInteractor = Mockito.mock(AddProductInteractor.class);
        productService = new ProductService(getProductInteractor, addProductInteractor);
    }

    @Test
    void testGetAllProducts() {
        // Arrange
        Product product1 = new Product("1", "Laptop", "Gaming laptop", 1500.00);
        Product product2 = new Product("2", "Mouse", "Wireless mouse", 50.00);
        List<Product> expectedProducts = Arrays.asList(product1, product2);

        when(getProductInteractor.execute()).thenReturn(expectedProducts);

        // Act
        List<Product> actualProducts = productService.getAllProducts();

        // Assert
        assertThat(actualProducts).isNotNull();
        assertThat(actualProducts).hasSize(2);
        assertThat(actualProducts).containsExactly(product1, product2);

        verify(getProductInteractor, times(1)).execute();
    }

    @Test
    void testAddProduct() {
        // Arrange
        AddProductDTO productDTO = new AddProductDTO("Keyboard", "Mechanical keyboard", 129.99);
        Product savedProduct = new Product("3", "Keyboard", "Mechanical keyboard", 129.99);

        when(addProductInteractor.execute(productDTO)).thenReturn(savedProduct);

        // Act
        Product actualProduct = productService.addProduct(productDTO);

        // Assert
        assertThat(actualProduct).isNotNull();
        assertThat(actualProduct.getId()).isEqualTo("3");
        assertThat(actualProduct.getName()).isEqualTo("Keyboard");

        verify(addProductInteractor, times(1)).execute(productDTO);
    }
}
