package com.demo.book.repository;

import com.demo.book.model.OrderInfo;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer oid);

    OrderInfo[] selectByUserId(Integer uid);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    Integer getOrdersCount();

    OrderInfo[] getOrderInfosFromX(Integer index);
}
