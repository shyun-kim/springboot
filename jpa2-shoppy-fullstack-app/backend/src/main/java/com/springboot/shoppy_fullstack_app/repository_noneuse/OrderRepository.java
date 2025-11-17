package com.springboot.shoppy_fullstack_app.repository_noneuse;


import com.springboot.shoppy_fullstack_app.dto.KakaoPayDto;

import java.util.List;

public interface OrderRepository {
    int deleteCartItem(List<Integer> cidList);
    int saveOrders(KakaoPayDto kakaoPay);
    int saveOrderDetail(KakaoPayDto kakaoPay);
}
