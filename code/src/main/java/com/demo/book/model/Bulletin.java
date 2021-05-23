package com.demo.book.model;

import lombok.Data;

import java.util.Date;

@Data
public class Bulletin {
    private Integer bltid;

    private String content;

    private Date time;

    private Boolean valid;
}
