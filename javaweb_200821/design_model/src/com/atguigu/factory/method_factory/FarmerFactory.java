package com.atguigu.factory.method_factory;

import com.atguigu.factory.bean.Farmer;
import com.atguigu.factory.bean.Worker;

public class FarmerFactory implements WorkerFactory {
    @Override
    public Worker create() {
        Farmer farmer=new Farmer();
        return farmer;
    }
}
