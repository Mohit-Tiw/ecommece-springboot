package com.mohit.ecommercedemo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductRequestDto {
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Long categoryId;
}
