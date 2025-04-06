package com.shop.shoe_backend.repository;

import com.shop.shoe_backend.entity.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, String> {
} 