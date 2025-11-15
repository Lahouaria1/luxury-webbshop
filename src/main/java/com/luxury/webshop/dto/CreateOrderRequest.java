// src/main/java/com/luxury/webshop/dto/CreateOrderRequest.java

package com.luxury.webshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @Email
    private String email;

    @NotEmpty
    private List<@NotNull OrderItemRequest> items;
}
