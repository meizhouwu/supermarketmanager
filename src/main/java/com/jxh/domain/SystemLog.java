package com.jxh.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SystemLog {
    private Long id;
    private Long operation_id;
    private String content;
    private Date create_time = new Date();

    private String operation;
}
