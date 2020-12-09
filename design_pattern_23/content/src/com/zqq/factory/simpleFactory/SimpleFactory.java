package com.zqq.factory.simpleFactory;

/**
 * 
 * 好处：可以在多处地方使用简化对象创建
 * 原理： 通过将对象的创建封装到一个类的静态方法中
 * 从而能够实现简化类创建的效果，而且在修改的时候只需要修改工厂类里的内用就行
 */
public class SimpleFactory {
    public static Pizza getPizza(String type){
        Pizza pizza=null;
        if ("FruitPizza".equalsIgnoreCase(type)){
            pizza=new FruitPizza();
        }else if ("MeatPizza".equalsIgnoreCase(type)){
            pizza=new MeatPizza();
        }
        return pizza;
    }
}
