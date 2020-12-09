package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    /**
     * 保存订单项目
     * @param orderItem
     * @return
     */
    Integer saveOrderItem(OrderItem orderItem);

    /**
     * 根据订单号查找所有的订单项目
     * @param orderId
     * @return
     */
    List<OrderItem> getOrderItemsByOrderId(String orderId);
}
