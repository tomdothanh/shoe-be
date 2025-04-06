package com.shop.shoe_backend.service;

import com.shop.shoe_backend.entity.Order;
import com.shop.shoe_backend.request.PaymentRequest;

public interface PaymentService {
    String initPayment(Order order, PaymentRequest paymentRequest);
} 