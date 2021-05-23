package com.demo.book.repository;

import com.demo.book.model.OrderItem;
import com.demo.book.model.OrderItemKey;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemMapper {
    int deleteByPrimaryKey(OrderItemKey key);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(OrderItemKey key);

    OrderItem[] selectByOrderId(Integer oid);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    void deleteByOrderId(Integer oid);
}
