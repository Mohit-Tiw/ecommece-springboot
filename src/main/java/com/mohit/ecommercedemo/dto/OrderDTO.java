package com.mohit.ecommercedemo.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private Long id;
    private Long userId;
    private Date orderDate;
    private String status;
    private List<OrderItemDTO> orderItems;

    // Nested DTO class for order items
    public static class OrderItemDTO {
        private Long productId;
        private Integer quantity;
        private Double priceAtPurchase;

        // Getters and Setters
    }

    // Getters and Setters
}

