package com.demo.book.service;

import com.demo.book.repository.BookMapper;
import com.demo.book.repository.CartItemMapper;
import com.demo.book.repository.OrderInfoMapper;
import com.demo.book.repository.OrderItemMapper;
import com.demo.book.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    final
    BookMapper bookMapper;

    final
    CartItemMapper cartItemMapper;

    final
    OrderInfoMapper orderInfoMapper;

    final
    OrderItemMapper orderItemMapper;

    public OrderService(BookMapper bookMapper, CartItemMapper cartItemMapper, OrderInfoMapper orderInfoMapper, OrderItemMapper orderItemMapper) {
        this.bookMapper = bookMapper;
        this.cartItemMapper = cartItemMapper;
        this.orderInfoMapper = orderInfoMapper;
        this.orderItemMapper = orderItemMapper;
    }

    public void deleteOrder(Integer oid) {
        orderInfoMapper.deleteByPrimaryKey(oid);
        orderItemMapper.deleteByOrderId(oid);
    }

    public OrderInfo selectByPrimaryKey(Integer oid) {
        return orderInfoMapper.selectByPrimaryKey(oid);
    }

    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    public OrderInfo[] getOrderInfosByUserId(Integer uid) {
        return orderInfoMapper.selectByUserId(uid);
    }

    public Map<OrderInfo, OrderItem[]> getOrdersByOrderInfos(OrderInfo[] orderInfos) {
        Map<OrderInfo, OrderItem[]> orders = new HashMap<>();
        for (OrderInfo orderInfo : orderInfos) {
            orders.put(orderInfo, orderItemMapper.selectByOrderId(orderInfo.getOid()));
        }
        return orders;
    }

    @Transactional
    public Boolean submitOrder(Integer uid) {
        CartItem[] cartItems = cartItemMapper.getCartItemByUserId(uid);
        if (cartItems == null || cartItems.length == 0) {
            return false;
        }
        Book[] books = new Book[cartItems.length];
        for (int i = 0; i < books.length; i++) {
            books[i] = bookMapper.selectByPrimaryKey(cartItems[i].getBid());
            if (books[i].getAmount() < cartItems[i].getQty()) {
                return false;
            }
            books[i].setAmount(books[i].getAmount() - cartItems[i].getQty());
        }

        for (Book book : books) {
            bookMapper.updateByPrimaryKeySelective(book);
            Book newBook = bookMapper.selectByPrimaryKey(book.getBid());
            if (!book.getAmount().equals(newBook.getAmount()) || newBook.getAmount() < 0) {
                throw new IllegalArgumentException("库存不足。");
            }
        }

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOid(null);
        orderInfo.setUid(uid);
        orderInfo.setStatus("交易中");
        orderInfo.setTime(new Date());
        orderInfoMapper.insertSelective(orderInfo);

        OrderItem[] orderItems = new OrderItem[cartItems.length];
        for (int i = 0; i < orderItems.length; i++) {
            orderItems[i] = new OrderItem();
            orderItems[i].setOid(orderInfo.getOid());
            orderItems[i].setBid(cartItems[i].getBid());
            orderItems[i].setQty(cartItems[i].getQty());
            orderItemMapper.insertSelective(orderItems[i]);

            CartItemKey cartItemKey = new CartItemKey();
            cartItemKey.setUid(uid);
            cartItemKey.setBid(cartItems[i].getBid());
            cartItemMapper.deleteByPrimaryKey(cartItemKey);
        }

        return true;
    }

    public Integer getOrdersCount() {
        return orderInfoMapper.getOrdersCount();
    }

    public OrderInfo[] getOrderInfosByPage(Integer page) {
        return orderInfoMapper.getOrderInfosFromX((page - 1) * 10);
    }

    public OrderItem[] selectByOrderId(Integer oid) {
        return orderItemMapper.selectByOrderId(oid);
    }
}
