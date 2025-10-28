package com.springboot.shoppy_fullstack_app.controller;

import com.springboot.shoppy_fullstack_app.dto.CartItem;
import com.springboot.shoppy_fullstack_app.dto.CartListResponse;
import com.springboot.shoppy_fullstack_app.dto.KakaoPay;
import com.springboot.shoppy_fullstack_app.service.CartService;
import com.springboot.shoppy_fullstack_app.service.KakaoPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;
    private KakaoPayService kakaoPayService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
        this.kakaoPayService = kakaoPayService;
    }

    @PostMapping("/deleteItem")
    public int deleteItem(@RequestBody CartItem cartItem) {
        return cartService.deleteItem(cartItem);
    }

    @PostMapping("/list")
    public List<CartListResponse> findList(@RequestBody CartItem cartItem) {
        return cartService.findList(cartItem);
    }

    @PostMapping("/count")
    public CartItem count(@RequestBody CartItem cartItem) {
        return cartService.getCount(cartItem);
    }

    @PostMapping("/updateQty")
    public int  updateQty(@RequestBody CartItem cartItem) {
        System.out.println("updateQty :: " + cartItem);
        return cartService.updateQty(cartItem);
    }

    @PostMapping("/checkQty")
    public CartItem checkQty(@RequestBody CartItem cartItem) {
        System.out.println("checkQty" + cartItem.getPid() + cartItem.getSize() + cartItem.getId());
        return cartService.checkQty(cartItem);
    }

    @PostMapping("/add")
    public int add(@RequestBody CartItem cartItem) {
        return cartService.add(cartItem);
    }
}
