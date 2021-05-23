package com.demo.book.model;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private Integer bid;

    private String bname;

    private String author;

    private String press;

    private Date date;

    private String category;

    private String descn;

    private Float price;

    private Integer amount;

    private Integer sales;
}
