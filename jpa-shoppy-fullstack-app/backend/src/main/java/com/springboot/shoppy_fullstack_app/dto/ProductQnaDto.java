package com.springboot.shoppy_fullstack_app.dto;

import com.springboot.shoppy_fullstack_app.entity.Product;
import com.springboot.shoppy_fullstack_app.entity.ProductQna;
import lombok.Data;

@Data
public class ProductQnaDto {
    private int qid;
    private String title;
    private String content;
    private boolean isComplete;
    private boolean isLock;
    private String id;
    private int pid;
    private String cdate;

    public ProductQnaDto() {}
    public ProductQnaDto(ProductQna entity) {
        this.qid = entity.getQid();
    }
}
