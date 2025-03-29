package com.shop.shoe_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "cart_id")
    private UUID cartId;

    @Column(name = "variant_id")
    private UUID variantId;

    private int quantity;
}