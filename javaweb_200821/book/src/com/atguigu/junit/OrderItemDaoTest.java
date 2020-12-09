package com.atguigu.junit;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao=new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"aa",10,new BigDecimal(100),new BigDecimal(10000),"13156548"));
    }
    @Test
    public void getOrderItemsByOrderId() {
        List<OrderItem> items = orderItemDao.getOrderItemsByOrderId("TB1&1603351193037");
        items.forEach(System.out::println);
    }

}