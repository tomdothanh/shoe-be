package com.shop.shoe_backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CartItemResponse {
    private UUID id;
    private UUID productId;
    private UUID variantId;
    private int quantity;
    private BigDecimal price;
    private String name;
    private String imageUrl;
    private String color;
    private String size;
} 