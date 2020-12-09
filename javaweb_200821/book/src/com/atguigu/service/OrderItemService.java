package com.atguigu.service;

import com.atguigu.pojo.OrderItem;

public interface OrderItemService {
    /**
     * 添加订单项目
     * @param orderItem
     * @return
     */
    Integer addOrderItem(OrderItem orderItem);
}
