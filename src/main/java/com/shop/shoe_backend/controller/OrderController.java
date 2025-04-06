package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.dto.OrderStatus;
import com.shop.shoe_backend.entity.Order;
import com.shop.shoe_backend.repository.OrderRepository;
import com.shop.shoe_backend.service.AuthService;
import com.shop.shoe_backend.service.OrderItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @Autowired
    private AuthService authService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        String userEmail = authService.getCurrentUserEmail();
        List<Order> orders = orderRepository.findByUserEmail(userEmail);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderDetail(@PathVariable UUID orderId) {
        String userEmail = authService.getCurrentUserEmail();
        
        // Get order and verify ownership
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        
        if (!order.getUserEmail().equals(userEmail)) {
            return ResponseEntity.status(403).build();
        }

        // Create response map
        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("items", orderItemService.getOrderItemsByOrderId(orderId));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable OrderStatus status) {
        String userEmail = authService.getCurrentUserEmail();
        List<Order> orders = orderRepository.findByUserEmailAndStatus(userEmail, status);
        return ResponseEntity.ok(orders);
    }
} 