package com.zqq.factory.simpleFactory;

public class PizzaStore {
    OrderManager orderManager;

    public PizzaStore(OrderManager orderManager) {
        this.orderManager = orderManager;
    }
}
