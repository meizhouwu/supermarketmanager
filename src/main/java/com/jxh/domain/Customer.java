package com.jxh.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author meizh
 * 顾客类
 */
@Data
public class Customer {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private Date create_time;
    private Date update_time;
}
