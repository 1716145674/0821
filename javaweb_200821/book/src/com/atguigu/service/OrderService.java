package com.atguigu.service;

import com.atguigu.pojo.Car;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 添加图书
     *
     * @param userId
     * @param car
     * @return
     */
    String addOrder(Integer userId, Car car);

    /**
     * 通过用户id找到当前用户的所有的订单
     * @param id
     * @return
     */
    List<Order> getOrdersByUserId(Integer id);

    /**
     * 根据订单号查找当前订单的所有订单商品
     * @param orderId
     * @return
     */
    List<OrderItem> getOrderItemsByOrderId(String orderId);

    /**
     * 确认收货
     * @param orderId
     * @param status
     */
    void receiveGoodsByOrderId(String orderId, Integer status);

    /**
     * 显示所有的订单
     * @return
     */
    List<Order> getAllOrders();
}
