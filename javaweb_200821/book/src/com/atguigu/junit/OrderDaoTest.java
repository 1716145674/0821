package com.atguigu.junit;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        Integer integer = orderDao.saveOrder(new Order("13156548", new Date(), new BigDecimal(1000), null, 10));
        System.out.println(integer);
    }

    @Test
    public void getOrdersByUserId() {
        List<Order> orders = orderDao.getOrdersByUserId(1);
        System.out.println(orders.size());
    }
    @Test
    public void changeOrderStatus() {
    }
    @Test
    public void getAllOrders() {
        List<Order> allOrders = orderDao.getAllOrders();

        allOrders.forEach(System.out::println);
    }
}