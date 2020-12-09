package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 保存order
     * @param order
     * @return
     */
    Integer saveOrder(Order order);

    /**
     * @param id
     * 根据用户id在数据库中查找该用户的所有订单
     * @return
     */
    List<Order> getOrdersByUserId(Integer id);

    /**
     * 根据订单号修改订单物流状态
     * @param orderId
     * @param status
     */
    void changeOrderStatus(String orderId, Integer status);

    /**
     * 从数据库中获得所有的订单信息
     * @return
     */
    List<Order> getAllOrders();
}
