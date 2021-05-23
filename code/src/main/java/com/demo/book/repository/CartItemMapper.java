package com.demo.book.repository;

import com.demo.book.model.CartItem;
import com.demo.book.model.CartItemKey;
import org.springframework.stereotype.Repository;


@Repository
public interface CartItemMapper {
    int deleteByPrimaryKey(CartItemKey key);

    int insert(CartItem record);

    int insertSelective(CartItem record);

    CartItem selectByPrimaryKey(CartItemKey key);

    int updateByPrimaryKeySelective(CartItem record);

    int updateByPrimaryKey(CartItem record);

    CartItem[] getCartItemByUserId(Integer uid);
}
