// src/main/java/com/luxury/webshop/dto/CreateOrderResponse.java
package com.luxury.webshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderResponse {
    private String orderId;
    private String message;
    private double totalAmount;
}
