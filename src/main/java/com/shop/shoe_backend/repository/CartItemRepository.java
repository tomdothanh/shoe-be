package com.shop.shoe_backend.repository;

import com.shop.shoe_backend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {

    Optional<CartItem> findByCartIdAndVariantId(UUID cartId, UUID variantId);

}
