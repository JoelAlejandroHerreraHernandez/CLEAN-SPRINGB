package com.example.demo.products.domain.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ProductTest {

    @Test
    void testProductBuilder() {
        Product product = Product.builder()
                .id("123")
                .name("Laptop")
                .description("High-end gaming laptop")
                .price(1500.00)
                .build();

        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo("123");
        assertThat(product.getName()).isEqualTo("Laptop");
        assertThat(product.getDescription()).isEqualTo("High-end gaming laptop");
        assertThat(product.getPrice()).isEqualTo(1500.00);
    }

    @Test
    void testNoArgsConstructor() {
        Product product = new Product();
        product.setId("456");
        product.setName("Smartphone");
        product.setDescription("Latest Android smartphone");
        product.setPrice(799.99);

        assertThat(product.getId()).isEqualTo("456");
        assertThat(product.getName()).isEqualTo("Smartphone");
        assertThat(product.getDescription()).isEqualTo("Latest Android smartphone");
        assertThat(product.getPrice()).isEqualTo(799.99);
    }

    @Test
    void testAllArgsConstructor() {
        Product product = new Product("789", "Tablet", "Lightweight tablet", 499.99);

        assertThat(product.getId()).isEqualTo("789");
        assertThat(product.getName()).isEqualTo("Tablet");
        assertThat(product.getDescription()).isEqualTo("Lightweight tablet");
        assertThat(product.getPrice()).isEqualTo(499.99);
    }

    @Test
    void testToString() {
        Product product = Product.builder()
                .id("101")
                .name("Monitor")
                .description("4K Ultra HD monitor")
                .price(299.99)
                .build();

        assertThat(product.toString()).contains("101", "Monitor", "4K Ultra HD monitor", "299.99");
    }

    @Test
    void testEqualsAndHashCode() {
        Product product1 = Product.builder()
                .id("202")
                .name("Keyboard")
                .description("Mechanical keyboard")
                .price(129.99)
                .build();

        Product product2 = Product.builder()
                .id("202")
                .name("Keyboard")
                .description("Mechanical keyboard")
                .price(129.99)
                .build();

        assertThat(product1).isEqualTo(product2);
        assertThat(product1.hashCode()).isEqualTo(product2.hashCode());
    }

}
