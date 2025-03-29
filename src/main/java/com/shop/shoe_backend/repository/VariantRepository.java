package com.shop.shoe_backend.repository;

import com.shop.shoe_backend.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VariantRepository extends JpaRepository<Variant, UUID> {

    List<Variant> findByProductId(UUID productId);
}
