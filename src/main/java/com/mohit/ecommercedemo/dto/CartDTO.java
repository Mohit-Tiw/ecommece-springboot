package com.mohit.ecommercedemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private Long userId;
    private List<CartItemDTO> cartItems;

    // Nested DTO class for cart items
    @Data
    public static class CartItemDTO {
        private Long productId;
        private Integer quantity;
    }
}

