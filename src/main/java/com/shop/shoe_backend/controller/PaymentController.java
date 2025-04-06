package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.dto.PaymentResponse;
import com.shop.shoe_backend.dto.OrderStatus;
import com.shop.shoe_backend.entity.*;
import com.shop.shoe_backend.repository.*;
import com.shop.shoe_backend.request.PaymentRequest;
import com.shop.shoe_backend.service.AuthService;
import com.shop.shoe_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

@RestController
@RequestMapping("/v1/payment")
public class PaymentController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ShippingInfoRepository shippingInfoRepository;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private VariantRepository variantRepository;

    @PostMapping("/init")
    public ResponseEntity<PaymentResponse> initPayment(@RequestBody PaymentRequest request) {
        String userEmail = authService.getCurrentUserEmail();

        // 3. Get existing shipping info
        ShippingInfo shippingInfo = shippingInfoRepository.findById(userEmail)
            .orElseThrow(() -> new RuntimeException("Shipping info not found. Please add shipping information before proceeding with payment."));

        // 1. Get user's cart and items
        Cart cart = cartRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());

        if (cartItems.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // 2. Calculate totals
        double subtotal = 0.0;
        for (CartItem cartItem : cartItems) {
            Variant variant = variantRepository.findById(cartItem.getVariantId())
                .orElseThrow(() -> new RuntimeException("Variant not found"));
            subtotal += cartItem.getQuantity() * variant.getPrice().doubleValue();
        }
        double shipping = 9.99; // Fixed shipping cost
        double tax = subtotal * 0.08; // 8% tax rate
        double totalAmount = subtotal + shipping + tax;

        // 4. Create order
        Order order = new Order();
        order.setUserEmail(userEmail);
        order.setSubtotal(subtotal);
        order.setShipping(shipping);
        order.setTax(tax);
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PENDING_PAYMENT);
        
        // Save order first and refresh it
        System.out.println("Saving order: " + order);
        order = orderRepository.saveAndFlush(order);

        // 5. Create order items
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Variant variant = variantRepository.findById(cartItem.getVariantId())
                .orElseThrow(() -> new RuntimeException("Variant not found"));
            
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setVariantId(cartItem.getVariantId());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(variant.getPrice().doubleValue());
            orderItems.add(orderItem);
        }
        // save all order items
        orderItemRepository.saveAll(orderItems);

        // Clear cart
        cartItemRepository.deleteAll(cartItems);

        try {
            // 6. Initialize payment with external service
            String paymentSecret = paymentService.initPayment(order, request);

            // 7. Return response with payment secret
            PaymentResponse response = new PaymentResponse();
            response.setOrderId(order.getId());
            response.setClientSecret(paymentSecret);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // If payment initialization fails, set order status to failed
            order.setStatus(OrderStatus.FAILED);
            orderRepository.save(order);
            throw new RuntimeException("Payment initialization failed", e);
        }
    }
} 