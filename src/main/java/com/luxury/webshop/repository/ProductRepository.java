// src/main/java/com/luxury/webshop/repository/ProductRepository.java
package com.luxury.webshop.repository;

import com.luxury.webshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProductRepository {

    private final Map<Long, Product> products = new ConcurrentHashMap<>();

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void save(Product p) {
        products.put(p.getId(), p);
    }

    public void saveAll(Collection<Product> list) {
        list.forEach(p -> products.put(p.getId(), p));
    }
}
