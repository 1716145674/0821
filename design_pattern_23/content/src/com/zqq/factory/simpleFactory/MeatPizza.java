package com.zqq.factory.simpleFactory;

public class MeatPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("肉披萨准备完成");
    }

}
