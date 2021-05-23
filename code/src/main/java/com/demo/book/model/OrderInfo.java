package com.demo.book.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    private Integer oid;

    private Integer uid;

    private String status;

    private Date time;
}
