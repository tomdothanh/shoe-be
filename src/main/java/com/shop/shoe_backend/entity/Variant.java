package com.shop.shoe_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name = "variants")
public class Variant {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "product_id")
    private UUID productId;

    private String color;
    private String size;
    private int quantity;

    @Column(name = "image_urls", columnDefinition = "jsonb")
    private List<String> imageUrls;

    private BigDecimal price;
}