package com.shop.shoe_backend.service.impl;

import com.shop.shoe_backend.entity.Order;
import com.shop.shoe_backend.request.PaymentRequest;
import com.shop.shoe_backend.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String initPayment(Order order, PaymentRequest paymentRequest) {
         // Set the Stripe API key
         Stripe.apiKey = "sk_test_51HNxXYDD1gzs0edaBErRDo3Ukw9rG6M9IeAc8DppKnDtvto5jXkpggeyqzMrcdz30xB1SYVg0mNeCe7DkyHJWHyF00PJGD3lec"; // Consider using a config property instead

         // Create a PaymentIntent
         PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                 .setAmount((long) (order.getTotalAmount() * 100)) // Amount in cents
                 .setCurrency("usd") // Set your currency
                 .build();
 
         try {
             PaymentIntent paymentIntent = PaymentIntent.create(params);
             return paymentIntent.getClientSecret(); // Return the client secret
         } catch (Exception e) {
             throw new RuntimeException("Failed to create payment intent", e);
         }
    }
} 