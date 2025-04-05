package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.entity.Cart;
import com.shop.shoe_backend.entity.CartItem;
import com.shop.shoe_backend.repository.CartItemRepository;
import com.shop.shoe_backend.repository.CartRepository;
import com.shop.shoe_backend.request.AddToCartRequest;
import com.shop.shoe_backend.service.AuthService;
import com.shop.shoe_backend.service.CartItemService;
import com.shop.shoe_backend.dto.CartItemResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<List<CartItemResponse>> getCart() {
        String userEmail = authService.getCurrentUserEmail();
        return ResponseEntity.ok(cartItemService.getCartItemsByUserEmail(userEmail));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addToCart(@RequestBody AddToCartRequest request) {
        String userEmail = authService.getCurrentUserEmail();

        Cart existingCart = cartRepository.findByUserEmail(userEmail).orElse(null);

        if (Objects.isNull(existingCart)) {
            var cart = new Cart();
            cart.setUserEmail(userEmail);
            existingCart = cartRepository.save(cart);
        }

        Optional<CartItem> existingCartItem = cartItemRepository.findByCartIdAndProductIdAndVariantId(existingCart.getId(), request.getProductId(), request.getVariantId());

        CartItem cartItem;
        if (existingCartItem.isPresent()) {
            cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
        } else {
            cartItem = new CartItem();
            cartItem.setProductId(request.getProductId());
            cartItem.setVariantId(request.getVariantId());
            cartItem.setQuantity(request.getQuantity());
            cartItem.setCartId(existingCart.getId());
        }
        cartItemRepository.save(cartItem);

        return ResponseEntity.ok().build();
    }
}