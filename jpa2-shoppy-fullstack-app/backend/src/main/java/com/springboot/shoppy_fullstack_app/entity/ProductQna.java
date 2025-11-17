package com.springboot.shoppy_fullstack_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product_qna")
@Getter @Setter
public class ProductQna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qid;
    private String title;
    private String content;
    private boolean isComplete;
    private boolean isLock;
    private String id;
    private int pid;
    private String cdate;

    //Entity <=> Dto 변환
    public ProductQna() {}
    public ProductQna(ProductQna entity) {
        this.qid = entity.getQid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.isComplete = entity.isComplete();
        this.isLock = entity.isLock();
        this.id = entity.getId();
        this.pid = entity.getPid();
        this.cdate = entity.getCdate();
    }
}
