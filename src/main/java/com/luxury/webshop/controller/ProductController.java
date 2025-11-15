// src/main/java/com/luxury/webshop/controller/ProductController.java

package com.luxury.webshop.controller;

import com.luxury.webshop.model.Product;
import com.luxury.webshop.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable long id) {
        return service.getById(id);
    }
}
