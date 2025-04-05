package com.shop.shoe_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private Double price;

    @Column(name = "image_url")
    private String imageUrl;
}