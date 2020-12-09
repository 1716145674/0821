package com.atguigu.factory.static_proxy;

public class YelloCattle implements BuyPhone {
    AppleFan appleFan;

    public YelloCattle(AppleFan appleFan) {
        this.appleFan = appleFan;
    }

    @Override
    public Double buyIphone12(Double money) {
        System.out.println("黄牛有资源");
        return appleFan.buyIphone12(money);
    }
}
