package com.atguigu.factory.static_proxy;

public class AppleFan implements BuyPhone {

    @Override
    public Double buyIphone12(Double money) {
        System.out.println("果粉买苹果12花了6000");
        return money ;
    }
}
