package com.shop.shoe_backend.service;

import com.shop.shoe_backend.entity.OrderItem;
import com.shop.shoe_backend.entity.Product;
import com.shop.shoe_backend.entity.Variant;
import com.shop.shoe_backend.repository.OrderItemRepository;
import com.shop.shoe_backend.repository.ProductRepository;
import com.shop.shoe_backend.repository.VariantRepository;
import com.shop.shoe_backend.response.OrderItemResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private VariantRepository variantRepository;

    public List<OrderItemResponse> getOrderItemsByOrderId(UUID orderId) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);
        if (orderItems == null) {
            return List.of();
        }
        
        return orderItems.stream()
                .map(this::convertToResponse)
                .sorted(Comparator.comparing(OrderItemResponse::getId))
                .collect(Collectors.toList());
    }

    private OrderItemResponse convertToResponse(OrderItem orderItem) {
        Product product = productRepository.findById(orderItem.getProductId()).orElse(null);
        Variant variant = variantRepository.findById(orderItem.getVariantId()).orElse(null);
        
        OrderItemResponse response = new OrderItemResponse();
        response.setId(orderItem.getId());
        response.setProductId(orderItem.getProductId());
        response.setVariantId(orderItem.getVariantId());
        response.setQuantity(orderItem.getQuantity());
        
        if (product != null) {
            response.setName(product.getName());
            response.setImageUrl(product.getImageUrl());
        }
        
        if (variant != null) {
            response.setColor(variant.getColor());
            response.setSize(variant.getSize());
            response.setPrice(variant.getPrice());
        }
        
        return response;
    }
} 