package com.atguigu.mapper;

import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    OrderItem queryOrderItemById(Integer id);
    List<OrderItem> queryOrderItemByTwoStep(Integer orderId);
}
