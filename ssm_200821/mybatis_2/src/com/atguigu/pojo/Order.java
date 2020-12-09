package com.atguigu.pojo;

import java.util.List;

public class Order {
    private Integer id;
    private String name;
    private List<OrderItem> orderItemList;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderItemList=" + orderItemList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Order() {
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
