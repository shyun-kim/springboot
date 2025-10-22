package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.Product;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailInfo;
import com.springboot.shoppy_fullstack_app.dto.ProductQna;
import com.springboot.shoppy_fullstack_app.dto.ProductReturn;

import java.util.List;

public interface ProductService {
    ProductReturn findReturn();
    List<ProductQna>  findQna(int pid);
    ProductDetailInfo findDetailInfo(int pid);
    Product findByPid(int pid);
    List<Product> findAll();
}
