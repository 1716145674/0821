package com.atguigu.factory.simple_factory;

import com.atguigu.factory.bean.Doctor;
import com.atguigu.factory.bean.Farmer;
import com.atguigu.factory.bean.Teacher;
import com.atguigu.factory.bean.Worker;

public class WorkerFactory {
    public static Worker createWorker(String worker){
        String upperWorker=worker.toUpperCase();
        switch (upperWorker){
            case "DOCTOR":
                return new Doctor();
            case "TEACHER":
                return new Teacher();
            case "FARMER":
                return new Farmer();
        }
        return null;
    }
}
