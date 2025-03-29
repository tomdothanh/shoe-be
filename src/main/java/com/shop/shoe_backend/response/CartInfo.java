package com.shop.shoe_backend.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartInfo {

    private BigDecimal totalPrice;
    private List<CartItemInfo> items;
}
