package com.luxury.webshop.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private String id;                 // e.g. UUID
    private CustomerInfo customerInfo;
    private List<OrderItem> items;
    private double totalAmount;
    private LocalDateTime orderDate;
}
