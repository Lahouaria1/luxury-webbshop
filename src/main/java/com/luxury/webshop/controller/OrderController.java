package com.luxury.webshop.controller;

import com.luxury.webshop.dto.CreateOrderRequest;
import com.luxury.webshop.dto.CreateOrderResponse;
import com.luxury.webshop.model.Order;
import com.luxury.webshop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public CreateOrderResponse create(@Valid @RequestBody CreateOrderRequest req) {
        Order saved = service.createOrder(req);
        return new CreateOrderResponse(saved.getId(), "Order created", saved.getTotalAmount());
    }
}
