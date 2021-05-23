package com.demo.book.model;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer uid;

    private Integer bid;

    private String content;

    private Date time;
}
