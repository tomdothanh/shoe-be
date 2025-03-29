package com.shop.shoe_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
}