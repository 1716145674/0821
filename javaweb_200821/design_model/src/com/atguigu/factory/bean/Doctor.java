package com.atguigu.factory.bean;

public class Doctor implements Worker {

    @Override
    public void work() {
        System.out.println("医生为病人看病！");
    }
}
