package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.entity.Product;
import com.shop.shoe_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable UUID productId) {
        return productRepository.findById(productId);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable UUID productId) {
        productRepository.deleteById(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable UUID productId, @RequestBody Product product) {
        if (productRepository.existsById(productId)) {
            product.setId(productId);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }
}