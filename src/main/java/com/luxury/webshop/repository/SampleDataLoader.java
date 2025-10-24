package com.luxury.webshop.repository;

import com.luxury.webshop.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleDataLoader {

    private final ProductRepository productRepository;

    public SampleDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void load() {
        productRepository.saveAll(List.of(
            Product.builder().id(1).name("Leather Wallet")
                .description("Premium calf leather wallet")
                .price(79.0).imageUrl("/img/wallet.jpg").stock(25).build(),
            Product.builder().id(2).name("Silk Scarf")
                .description("100% silk")
                .price(59.0).imageUrl("/img/scarf.jpg").stock(40).build(),
            Product.builder().id(3).name("Gold Cufflinks")
                .description("18k gold plated")
                .price(149.0).imageUrl("/img/cufflinks.jpg").stock(10).build()
        ));
    }
}
