package com.atguigu.dao.impl;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;
import com.atguigu.utils.BaseDao;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {
    @Override
    public Integer saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(id,name,count,price,total_price,order_id) " +
                "values(?,?,?,?,?,?)";
        return update(sql,null,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        String sql=" select id,name,count,price,total_price totalPrice ,order_id orderId " +
                " from t_order_item where order_id = ? ";
        return queryList(sql,orderId);
    }
}
