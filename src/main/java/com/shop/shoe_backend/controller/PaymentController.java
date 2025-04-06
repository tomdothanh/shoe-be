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
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
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
    private PaymentService paymentService;

    @Autowired
    private VariantRepository variantRepository;

    @PostMapping("/init")
    public ResponseEntity<PaymentResponse> initPayment(@RequestBody PaymentRequest request) {
        String userEmail = authService.getCurrentUserEmail();

        // 1. Get user's cart and items for new order
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

        // Create new order
        String orderNumber = "ORD-" + LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")) + 
            "-" + String.format("%05d", (int)(Math.random() * 100000));

        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setUserEmail(userEmail);
        order.setSubtotal(subtotal);
        order.setShipping(shipping);
        order.setTax(tax);
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.PENDING_PAYMENT);
        order.setCreatedAt(LocalDateTime.now());

        try {
            // Initialize payment with external service
            String clientSecret = paymentService.initPayment(order, request);

            order.setClientSecret(clientSecret);
            order = orderRepository.save(order);

              // Create order items
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
            orderItemRepository.saveAll(orderItems);

            // Clear cart
            cartItemRepository.deleteAll(cartItems);

            // Return response with payment secret
            PaymentResponse response = new PaymentResponse();
            response.setOrderId(order.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // If payment initialization fails, set order status to failed
            throw new RuntimeException("Payment initialization failed", e);
        }
    }
} 