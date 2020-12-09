package com.zqq.factory.simpleFactory;

public class OrderManager {
    Pizza pizza;

    public OrderManager(Pizza pizza) {
        this.pizza = pizza;
    }
    public void finish(){
        pizza.prepare();
        pizza.cook();
        pizza.cut();
        pizza.box();
    }
}
