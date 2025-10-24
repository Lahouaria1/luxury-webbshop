package com.luxury.webshop.service;

import com.luxury.webshop.exception.NotFoundException;
import com.luxury.webshop.model.Product;
import com.luxury.webshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Test
    void getById_returnsProductOrThrows() {
        ProductRepository repo = new ProductRepository();
        repo.saveAll(List.of(Product.builder().id(10).name("Test").price(1.0).build()));
        ProductService service = new ProductService(repo);

        assertEquals(10, service.getById(10).getId());
        assertThrows(NotFoundException.class, () -> service.getById(99));
    }
}
