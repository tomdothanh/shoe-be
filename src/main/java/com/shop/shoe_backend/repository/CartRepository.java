package com.shop.shoe_backend.repository;

import com.shop.shoe_backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByUserEmail(String userEmail);
}
