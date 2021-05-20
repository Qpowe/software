package com.demo.book.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CartItem extends CartItemKey {
    private Integer qty;
}
