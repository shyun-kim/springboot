package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.CartItem;

public interface CartRepository {
    int updateQty(CartItem cartItem);
    CartItem checkQty(CartItem cartItem);
    int add(CartItem cartItem);
}
