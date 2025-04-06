package com.shop.shoe_backend.request;

import lombok.Data;

@Data
public class PaymentRequest {
    // Stripe Payment Method ID (created by Stripe.js on frontend)
    private String paymentMethodId;
} 