package com.atguigu.pojo;

public class OrderItem {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name +
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


    public OrderItem() {
    }

    public OrderItem(Integer id, String name, Order order) {
        this.id = id;
        this.name = name;
    }
}
