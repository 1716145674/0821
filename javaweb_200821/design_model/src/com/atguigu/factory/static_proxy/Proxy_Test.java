package com.atguigu.factory.static_proxy;

public class Proxy_Test {
    public static void main(String[] args) {
        AppleFan appleFan = new AppleFan();
        YelloCattle yelloCattle = new YelloCattle(appleFan);
        Double aDouble = yelloCattle.buyIphone12(5000d);


    }
}
