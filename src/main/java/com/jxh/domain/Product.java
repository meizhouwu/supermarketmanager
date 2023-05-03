package com.jxh.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author meizh
 */
@Data
public class Product {
    private Long id;
    private String code;
    private String name;
    private BigDecimal price;
    private Integer stock;
    private Long category_id;
    private Long supplier_id;
    private String desc;

    private String category;
    private String supplier;

}
