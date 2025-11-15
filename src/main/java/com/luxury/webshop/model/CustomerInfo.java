// src/main/java/com/luxury/webshop/model/CustomerInfo.java

package com.luxury.webshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerInfo {
    private String name;
    private String address;
    private String email;
}
