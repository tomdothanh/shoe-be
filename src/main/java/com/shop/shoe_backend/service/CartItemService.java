package com.shop.shoe_backend.service;

import com.shop.shoe_backend.dto.CartItemResponse;
import com.shop.shoe_backend.entity.Cart;
import com.shop.shoe_backend.entity.CartItem;
import com.shop.shoe_backend.entity.Product;
import com.shop.shoe_backend.entity.Variant;
import com.shop.shoe_backend.repository.CartItemRepository;
import com.shop.shoe_backend.repository.CartRepository;
import com.shop.shoe_backend.repository.ProductRepository;
import com.shop.shoe_backend.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private VariantRepository variantRepository;

    public List<CartItemResponse> getCartItemsByUserEmail(String userEmail) {
        Cart cart = cartRepository.findByUserEmail(userEmail).orElse(null);
        if (cart == null) {
            return List.of();
        }
        
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
        return cartItems.stream()
                .map(this::convertToResponse)
                .sorted(Comparator.comparing(CartItemResponse::getId))
                .collect(Collectors.toList());
    }

    private CartItemResponse convertToResponse(CartItem cartItem) {
        Product product = productRepository.findById(cartItem.getProductId()).orElse(null);
        Variant variant = variantRepository.findById(cartItem.getVariantId()).orElse(null);
        
        CartItemResponse response = new CartItemResponse();
        response.setId(cartItem.getId());
        response.setProductId(cartItem.getProductId());
        response.setVariantId(cartItem.getVariantId());
        response.setQuantity(cartItem.getQuantity());
        
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