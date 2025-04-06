package com.shop.shoe_backend.controller;

import com.shop.shoe_backend.entity.ShippingInfo;
import com.shop.shoe_backend.repository.ShippingInfoRepository;
import com.shop.shoe_backend.request.ShippingInfoRequest;
import com.shop.shoe_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shipping-info")
public class ShippingInfoController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ShippingInfoRepository shippingInfoRepository;

    @PostMapping
    public ResponseEntity<ShippingInfo> addShippingInfo(@RequestBody ShippingInfoRequest request) {
        String userEmail = authService.getCurrentUserEmail();
        
        // Check if shipping info already exists
        if (shippingInfoRepository.existsById(userEmail)) {
            return ResponseEntity.badRequest().build();
        }

        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setEmail(userEmail);
        shippingInfo.setFirstName(request.getFirstName());
        shippingInfo.setLastName(request.getLastName());
        shippingInfo.setPhone(request.getPhone());
        shippingInfo.setAddress(request.getAddress());
        shippingInfo.setCity(request.getCity());
        shippingInfo.setState(request.getState());
        shippingInfo.setZipCode(request.getZipCode());
        shippingInfo.setCountry(request.getCountry());

        return ResponseEntity.ok(shippingInfoRepository.save(shippingInfo));
    }

    @PutMapping
    public ResponseEntity<ShippingInfo> updateShippingInfo(@RequestBody ShippingInfoRequest request) {
        String userEmail = authService.getCurrentUserEmail();
        
        ShippingInfo existingInfo = shippingInfoRepository.findById(userEmail)
                .orElseThrow(() -> new RuntimeException("Shipping info not found"));

        existingInfo.setFirstName(request.getFirstName());
        existingInfo.setLastName(request.getLastName());
        existingInfo.setPhone(request.getPhone());
        existingInfo.setAddress(request.getAddress());
        existingInfo.setCity(request.getCity());
        existingInfo.setState(request.getState());
        existingInfo.setZipCode(request.getZipCode());
        existingInfo.setCountry(request.getCountry());

        return ResponseEntity.ok(shippingInfoRepository.save(existingInfo));
    }

    @GetMapping
    public ResponseEntity<ShippingInfo> getShippingInfo() {
        String userEmail = authService.getCurrentUserEmail();
        
        return shippingInfoRepository.findById(userEmail)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
} 