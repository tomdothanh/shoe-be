package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.entity.Variant;
import com.shop.shoe_backend.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/variants")
public class VariantController {

    @Autowired
    private VariantRepository variantRepository;

    @GetMapping("/product/{productId}")
    public List<Variant> getVariantsByProductId(@PathVariable UUID productId) {
        return variantRepository.findByProductId(productId);
    }

    @GetMapping("/{variantId}")
    public Variant getVariantById(@PathVariable UUID variantId) {
        return variantRepository.findById(variantId).orElse(null);
    }

    @PostMapping
    public Variant saveVariant(@RequestBody Variant variant) {
        return variantRepository.save(variant);
    }

}
