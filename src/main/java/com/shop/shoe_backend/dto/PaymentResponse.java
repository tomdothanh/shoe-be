package com.shop.shoe_backend.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PaymentResponse {
    private UUID orderId;
} 