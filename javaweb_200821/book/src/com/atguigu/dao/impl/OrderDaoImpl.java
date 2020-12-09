package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.utils.BaseDao;

import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    @Override
    public Integer saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) " +
                "values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> getOrdersByUserId(Integer id) {
        String sql = "select order_id orderId ,create_time createTime,price, status ,user_id userId " +
                "from t_order where user_id=?";
        return queryList(sql, id);
    }

    @Override
    public void changeOrderStatus(String orderId, Integer status) {
        String sql=" update t_order set status=? where order_id=?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        String sql="select order_id orderId,create_time createTime, price,status,user_id userId from t_order";
        return queryList(sql);
    }
}
