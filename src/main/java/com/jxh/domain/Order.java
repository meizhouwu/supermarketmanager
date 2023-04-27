package com.jxh.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author meizh
 * 订单类
 */
@Data
public class Order {
    private Long id;
    private String order_sn;
    private Date create_time = new Date();
    private BigDecimal total_price;
    private Integer state;
    private Long customer_id;

    private String customer;
}
