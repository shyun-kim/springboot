package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcTemplateMemberRepository implements MemberRepository{
    //생성자
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource); //커넥션 생성
    }

    @Override
    public int save(Member member) {
        System.out.println("memberRepository.save-->");
        System.out.println(member.getId());

        //jdbcTemplate 객체를 이용하여 DB의 member 테이블에 insert
        String sql="insert into member(id, pwd, name, phone, email, mdate) values (?, ?, ?, ?, ?, now())"; //prepareStatement
        Object [] param = { member.getId(),
                            member.getPwd(),
                            member.getName(),
                            member.getPhone(),
                            member.getEmail() };
        int rows = jdbcTemplate.update(sql, param);
//        System.out.println("rows==>"+rows);
        return rows;
    }

    @Override
    public Long findById(String id) {
        String sql="select count(id) from member where id = ?";
        Long count = jdbcTemplate.queryForObject(sql, Long.class, id);
        return count;
    }
}
