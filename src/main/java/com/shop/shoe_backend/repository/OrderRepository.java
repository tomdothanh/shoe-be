package com.shop.shoe_backend.repository;

import com.shop.shoe_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findByUserEmail(String userEmail);
    List<Order> findByUserEmailAndStatus(String userEmail, String status);
} 