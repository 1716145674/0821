package com.atguigu.factory.method_factory;

import com.atguigu.factory.bean.Worker;

public class M_F_Test {
    public static void main(String[] args) {
        Worker farmer=new FarmerFactory().create();
        farmer.work();
    }
}
