package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.entity.Cart;
import com.shop.shoe_backend.entity.CartItem;
import com.shop.shoe_backend.repository.CartItemRepository;
import com.shop.shoe_backend.repository.CartRepository;
import com.shop.shoe_backend.request.AddToCartRequest;
import com.shop.shoe_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("v1/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping
    public Cart getCart() {
        String userEmail = authService.getCurrentUserEmail();

        return cartRepository.findByUserEmail(userEmail)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUserEmail(userEmail);
                    return cartRepository.save(cart);
                });
    }

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody AddToCartRequest request) {
        String userEmail = authService.getCurrentUserEmail();

        Cart existingCart = cartRepository.findByUserEmail(userEmail).orElse(null);

        if (Objects.isNull(existingCart)) {
            var cart = new Cart();
            cart.setUserEmail(userEmail);
            existingCart = cartRepository.save(cart);
        }

        Optional<CartItem> existingCartItem = cartItemRepository.findByCartIdAndVariantId(existingCart.getId(), request.getVariantId());

        CartItem cartItem;
        if (existingCartItem.isPresent()) {
            cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
        } else {
            cartItem = new CartItem();
            cartItem.setVariantId(request.getVariantId());
            cartItem.setQuantity(request.getQuantity());
            cartItem.setCartId(existingCart.getId());
        }
        cartItemRepository.save(cartItem);

        return ResponseEntity.ok().build();
    }
}