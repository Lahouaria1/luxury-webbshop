// src/main/java/com/luxury/webshop/model/OrderItem.java

package com.luxury.webshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private long productId;
    private int quantity;
    private double priceAtPurchase;
}
