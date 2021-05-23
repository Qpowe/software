package com.demo.book.model;

import lombok.Data;

@Data
public class User {
    private Integer uid;

    private String pwd;

    private String uname;

    private String sex;

    private String identity;

    private String email;

    private String phone;

    private String address;
}
