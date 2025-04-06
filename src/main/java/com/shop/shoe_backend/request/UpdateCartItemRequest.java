package com.shop.shoe_backend.request;

import lombok.Data;
import java.util.UUID;

@Data
public class UpdateCartItemRequest {
    private Integer quantity;
    private UUID productId;
    private UUID variantId;
} 