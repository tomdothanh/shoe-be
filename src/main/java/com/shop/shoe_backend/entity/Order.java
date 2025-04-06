package com.shop.shoe_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

import com.shop.shoe_backend.dto.OrderStatus;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "order_number", nullable = false, unique = true)
    private String orderNumber;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "subtotal", nullable = false)
    private Double subtotal;

    @Column(name = "shipping", nullable = false)
    private Double shipping;

    @Column(name = "tax", nullable = false)
    private Double tax;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}