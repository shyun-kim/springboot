package com.springboot.shoppy_fullstack_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "product")
@Getter @Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String name;
    private long price;
    private String info;
    private double rate;
    private String image;

    @Column(columnDefinition = "JSON")
    private String imgList;

    //Product(1) : (1...N)ProductDetailinfo
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //앞의 One은 Primary key , 뒤의 one은 primary key를 참조하는 테이블의 값 - 참조하는 값이 중복되는게 있으면 OneToMany
    private ProductDetailinfo detailinfo;

    //Product(1) : (1..N)ProductQna
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //앞의 One은 Primary key , 뒤의 one은 primary key를 참조하는 테이블의 값 - 참조하는 값이 중복되는게 있으면 OneToMany
    private List<ProductQna> qna;

}


