package com.shop.shoe_backend.request;

import lombok.Data;

import java.util.UUID;

@Data
public class AddToCartRequest {

    private UUID productId;
    private UUID variantId;
    private int quantity;
}
