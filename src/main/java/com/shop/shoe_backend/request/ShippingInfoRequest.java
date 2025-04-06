package com.shop.shoe_backend.request;

import lombok.Data;

@Data
public class ShippingInfoRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
} 