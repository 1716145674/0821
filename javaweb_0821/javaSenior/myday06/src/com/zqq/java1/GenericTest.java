package com.zqq.java1;

import org.junit.Test;

public class GenericTest {

    @Test
    public void test(){
        Order order = new Order();
        order.setOrder(123);
        order.setOrder("aff");

        System.out.println(order.getOrder());


    }
}
class Order<T>{
    private String name;
    T order;
    public  Order(){

    }
    public  Order(String name,T order){
        this.name=name;
        this.order=order;

    }
    public T getOrder(){
        return order;
    }
    public  void setOrder(T order){
        this.order=order;
    }


}