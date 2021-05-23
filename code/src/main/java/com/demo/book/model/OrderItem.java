package com.demo.book.model;

import lombok.Data;

@Data
public class OrderItem extends OrderItemKey {
    private Integer qty;
}
