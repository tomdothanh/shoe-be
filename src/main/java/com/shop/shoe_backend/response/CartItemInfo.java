package com.shop.shoe_backend.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CartItemInfo {
    private UUID id;

    private UUID variantId;
    private String color;
    private String size;

    private UUID productId;
    private String productName;
    private String productImage;
    private BigDecimal productPrice;

    private int quantity;
    private BigDecimal totalPrice;

}
