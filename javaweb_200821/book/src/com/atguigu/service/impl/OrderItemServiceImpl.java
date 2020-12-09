package com.atguigu.service.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDao orderItemDao=new OrderItemDaoImpl();
    @Override
    public Integer addOrderItem(OrderItem orderItem) {
        return orderItemDao.saveOrderItem(orderItem);
    }
}
