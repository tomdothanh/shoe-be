package com.shop.shoe_backend.request;

import java.util.UUID;

import lombok.Data;

@Data
public class PaymentRequest {
    // Stripe Payment Method ID (created by Stripe.js on frontend)
    private UUID orderId;
} 