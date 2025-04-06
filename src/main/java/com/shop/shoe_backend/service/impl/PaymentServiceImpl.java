package com.shop.shoe_backend.service.impl;

import com.shop.shoe_backend.entity.Order;
import com.shop.shoe_backend.request.PaymentRequest;
import com.shop.shoe_backend.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String initPayment(Order order, PaymentRequest paymentRequest) {
        // This will be replaced by actual payment service call
        // For now, return a mock payment secret
        return "pi_" + System.currentTimeMillis();
    }
} 