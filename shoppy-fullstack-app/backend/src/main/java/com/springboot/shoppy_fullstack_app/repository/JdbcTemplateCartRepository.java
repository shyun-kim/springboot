package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.CartItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcTemplateCartRepository implements CartRepository{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateCartRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CartItem checkQty(CartItem cartItem) {
        String sql = """
                select cid, sum(pid=? and size=?) as checkQty from cart
                where pid = ? and size = ?
                group by cid
                """;
        Object[] params = { cartItem.getPid(), cartItem.getSize() };
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(CartItem.class), params);
    }

    @Override
    public int add(CartItem cartItem) {
        //DB 연동
        String sql = """
                insert into cart(size, qty, pid, id, cdate)
                    values(?, ?, ?, ?, now())
                """;
        Object [] params = {
                cartItem.getSize(),
                cartItem.getQty(),
                cartItem.getCid(),
                cartItem.getId(),
        };
        return jdbcTemplate.update(sql, params);
    }
}
