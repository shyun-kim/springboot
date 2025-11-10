package com.springboot.shoppy_fullstack_app.entity;

import com.springboot.shoppy_fullstack_app.dto.SupportDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "support")
@Getter @Setter
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String title;
    private String content;
    private String stype;
    private int hits;
    private String rdate; //데이터를 넣을때는 LocaleDate 타입으로

    // DTO <> Entity : DB 연동 작업 진행시 데이터를 DB에 삽입
    public Support() {};
    public Support(SupportDto dto) {
        this.sid = dto.getSid();
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.stype = dto.getStype();
        this.hits = dto.getHits();
        this.rdate = dto.getRdate();
    }
}
