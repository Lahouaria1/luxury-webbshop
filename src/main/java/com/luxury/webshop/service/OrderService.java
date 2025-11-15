// src/main/java/com/luxury/webshop/service/OrderService.java

package com.luxury.webshop.service;

import com.luxury.webshop.dto.CreateOrderRequest;
import com.luxury.webshop.dto.OrderItemRequest;
import com.luxury.webshop.exception.NotFoundException;
import com.luxury.webshop.model.CustomerInfo;
import com.luxury.webshop.model.Order;
import com.luxury.webshop.model.OrderItem;
import com.luxury.webshop.model.Product;
import com.luxury.webshop.repository.OrderRepository;
import com.luxury.webshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public Order createOrder(CreateOrderRequest req) {

        // Validate and build order items
        List<OrderItem> items = new ArrayList<>();

        for (OrderItemRequest ir : req.getItems()) {
            Product p = productRepo.findById(ir.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product " + ir.getProductId() + " not found"));

            items.add(OrderItem.builder()
                    .productId(p.getId())
                    .quantity(ir.getQuantity())
                    .priceAtPurchase(p.getPrice())
                    .build());
        }

        double total = items.stream()
                .collect(Collectors.summingDouble(i -> i.getPriceAtPurchase() * i.getQuantity()));

        Order order = Order.builder()
                .id(UUID.randomUUID().toString())
                .customerInfo(CustomerInfo.builder()
                        .name(req.getName())
                        .address(req.getAddress())
                        .email(req.getEmail())
                        .build())
                .items(items)
                .totalAmount(total)
                .orderDate(LocalDateTime.now())
                .build();

        return orderRepo.save(order);
    }
}
