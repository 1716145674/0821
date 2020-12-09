package com.atguigu.factory.bean;

public class Farmer  implements Worker{


    @Override
    public void work() {
        System.out.println("农民种植粮食！");
    }
}
