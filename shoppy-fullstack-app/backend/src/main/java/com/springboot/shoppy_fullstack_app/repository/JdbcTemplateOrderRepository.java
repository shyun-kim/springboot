package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.KakaoPay;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateOrderRepository implements OrderRepository{
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveOrders(KakaoPay kakaoPay) {
        String sql = """
                insert into orders(
                	order_code,
                	member_id,
                    shipping_fee,
                    discount_amount,
                    total_amount,
                    receiver_name,
                    receiver_phone,
                    zipcode,
                    address1,
                    address2,
                    memo,
                    odate)
                values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now());
                """;
        Object[] params = {
                kakaoPay.getOrderId(),
                kakaoPay.getUserId(),
                kakaoPay.getPaymentInfo().getShippingFee(),
                kakaoPay.getPaymentInfo().getDiscountAmount(),
                kakaoPay.getPaymentInfo().getTotalAmount(),
                kakaoPay.getReceiver().getName(),
                kakaoPay.getReceiver().getPhone(),
                kakaoPay.getReceiver().getZipcode(),
                kakaoPay.getReceiver().getAddress1(),
                kakaoPay.getReceiver().getAddress2(),
                kakaoPay.getReceiver().getMemo()
        };
        return jdbcTemplate.update(sql, params);
    }

    @Override
    public int saveOrderDetail(KakaoPay kakaoPay) {
        String sql_orders = """
                insert into order_detail(order_code, pid, pname, size, qty, pid_total_price, discount)
                select
                    :orderCode, pid, name as pname, size, qty, totalPrice as pid_total_price,
                    :discount
                from view_cartlist
                where cid in (:cidList)
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("orderCode", kakaoPay.getOrderId());
        params.put("discount", kakaoPay.getPaymentInfo().getDiscountAmount());
        params.put("cidList", kakaoPay.getCidList());

        return namedParameterJdbctemplate.update(sql_orders, params);
    }
}
