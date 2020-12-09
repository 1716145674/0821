package com.zqq.factory.simpleFactory;

public class FruitPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("水果披萨准备完成");
    }

}
