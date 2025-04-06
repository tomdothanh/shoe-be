package com.shop.shoe_backend.repository;

import com.shop.shoe_backend.entity.Order;
import com.shop.shoe_backend.dto.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByUserEmail(String userEmail);
    List<Order> findByUserEmailAndStatus(String userEmail, OrderStatus status);
    Optional<Order> findByOrderNumber(String orderNumber);
} 