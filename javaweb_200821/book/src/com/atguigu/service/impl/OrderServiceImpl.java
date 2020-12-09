package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public String addOrder(Integer userId, Car car) {
        //生成唯一订单号
        String orderId = "TB:" + userId + System.currentTimeMillis();
        orderDao.saveOrder(new Order(orderId, new Date(), car.getCarTotalPrice(), null, userId));
        //生成订单项目到数据库
        for (CarItem carItem : car.getCarItems().values()) {
            orderItemDao.saveOrderItem(new OrderItem(null, carItem.getName(), carItem.getItemCount(),
                    carItem.getItemPrice(), carItem.getItemTotalPrice(), orderId));
            //根据图书id找到图书对象
            Book book = bookDao.queryBookById(carItem.getId());
            //修改此图书的库存和销量
            book.setSales(book.getSales() + carItem.getItemCount());
            book.setStock(book.getStock() - carItem.getItemCount());
            bookDao.updateBook(book);
        }
        return orderId;
    }


    @Override
    public List<Order> getOrdersByUserId(Integer id) {
        return orderDao.getOrdersByUserId(id);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        return orderItemDao.getOrderItemsByOrderId(orderId);
    }

    @Override
    public void receiveGoodsByOrderId(String orderId, Integer status) {
        orderDao.changeOrderStatus(orderId,status);
    }

    @Override
    public List<Order> getAllOrders() {

        return orderDao.getAllOrders();
    }
}
