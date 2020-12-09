package com.atguigu.factory.simple_factory;

import com.atguigu.factory.bean.Worker;

public class S_F_Test {
    public static void main(String[] args) {
        Worker doctor=WorkerFactory.createWorker("doctor");
        doctor.work();
        Worker teacher=WorkerFactoryWithEnum.createWorker(Workers.TEACHER);
        teacher.work();
    }
}
