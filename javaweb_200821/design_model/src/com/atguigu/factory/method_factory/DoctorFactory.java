package com.atguigu.factory.method_factory;

import com.atguigu.factory.bean.Doctor;
import com.atguigu.factory.bean.Worker;

public class DoctorFactory implements WorkerFactory {
    @Override
    public Worker create() {
        Doctor doctor=new Doctor();
        return doctor;
    }
}
