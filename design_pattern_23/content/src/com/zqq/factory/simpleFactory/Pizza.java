package com.zqq.factory.simpleFactory;

public abstract class Pizza {
    public abstract void prepare();
    public void cook (){
        System.out.println("披萨烘焙");
    }
    public void cut (){
        System.out.println("披萨切割");
    }
    public void box (){
        System.out.println("披萨打包");
    }
}
