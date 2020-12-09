package com.zqq.java;

public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory ajFactory = new AjFactory();
        ClothFactory proxyFactory= new ProxyFactory(ajFactory);
        proxyFactory.produceCloth();

    }
}

interface ClothFactory{
    void produceCloth();
}

class ProxyFactory implements ClothFactory{
    ClothFactory clothFactory;
    public  ProxyFactory( ClothFactory clothFactory){
        this.clothFactory=clothFactory;
    }
    @Override
    public void produceCloth() {
        System.out.println("代理工厂开始工作");
        clothFactory.produceCloth();
        System.out.println("代理工厂完成收尾工作");
    }
}

class AjFactory implements ClothFactory{


    @Override
    public void produceCloth() {
        System.out.println("生产Aj产品");
    }
}
