package com.atguigu.pojo;

import java.math.BigDecimal;

public class CarItem {
    private Integer id;
    private String name;
    //商品的总个数
    private Integer itemCount;
    //商品的单价
    private BigDecimal itemPrice;
    //商品的总价
    private BigDecimal itemTotalPrice;

    public CarItem() {
    }

    public CarItem(Integer id, String name, Integer itemCount, BigDecimal itemPrice, BigDecimal itemTotalPrice) {
        this.id = id;
        this.name = name;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.itemTotalPrice = itemTotalPrice;
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

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(BigDecimal itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    @Override
    public String toString() {
        return "CarItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemCount=" + itemCount +
                ", itemPrice=" + itemPrice +
                ", itemTotalPrice=" + itemTotalPrice +
                '}';
    }
}

