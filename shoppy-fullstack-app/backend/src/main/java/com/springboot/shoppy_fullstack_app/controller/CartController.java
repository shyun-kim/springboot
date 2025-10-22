package com.springboot.shoppy_fullstack_app.controller;

import com.springboot.shoppy_fullstack_app.dto.CartItem;
import com.springboot.shoppy_fullstack_app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/checkQty")
    public String checkQty(@RequestBody CartItem cartItem) {
        String result = cartService.checkQty(cartItem);
        return "";
    }

    @PostMapping("/add")
    public int add(@RequestBody CartItem cartItem) {
        return cartService.add(cartItem);
    }
}
