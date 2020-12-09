package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    //购物车里的所有商品的集合 string 为id
    private Map<Integer ,CarItem> carItems=new LinkedHashMap<>();

    public Car() {
    }

    public Car(Map<Integer, CarItem> carItems) {
        this.carItems = carItems;
    }

    public Map<Integer, CarItem> getCarItems() {
        return carItems;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carItems=" + carItems +
                '}';
    }

    public void setCarItems(Map<Integer, CarItem> carItems) {
        this.carItems = carItems;
    }
    //购物车的crud操作
    //添加
    public void addItem(CarItem carItem){
        if (!carItems.containsKey(carItem.getId())) {
            carItems.put(carItem.getId(),carItem);
        }else {
            CarItem item = carItems.get(carItem.getId());
            item.setItemCount(item.getItemCount()+1);
            item.setItemTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getItemCount())));
        }
    }
    //删除
    public void deleteItem(Integer id){
        carItems.remove(id);
    }
    //修改商品的数量
    public  void updateItemCountById(Integer id,Integer itemCount){
        CarItem carItem = carItems.get(id);
        if (carItem!=null){
            carItem.setItemCount(itemCount);
            carItem.setItemTotalPrice(carItem.getItemPrice().multiply(new BigDecimal(carItem.getItemCount())));
        }
    }
    //清空购物车
    public void clear(){
        carItems.clear();
    }
    //获得所有商品的总数量
    public Integer getCarCount(){
        Integer count=0;
        for (Map.Entry<Integer, CarItem> entry : carItems.entrySet()) {
            count+=entry.getValue().getItemCount();
        }
        return count;
    }
    //获得所有商品的总价格
    public BigDecimal getCarTotalPrice(){
        BigDecimal totalPrice=new BigDecimal(0);
        for (Map.Entry<Integer, CarItem> entry : carItems.entrySet()) {
            totalPrice=totalPrice.add(entry.getValue().getItemTotalPrice());
        }
        return totalPrice;
    }

}
