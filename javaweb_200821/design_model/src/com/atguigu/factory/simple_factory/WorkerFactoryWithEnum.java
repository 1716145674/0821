package com.atguigu.factory.simple_factory;

import com.atguigu.factory.bean.Doctor;
import com.atguigu.factory.bean.Farmer;
import com.atguigu.factory.bean.Teacher;
import com.atguigu.factory.bean.Worker;

public class WorkerFactoryWithEnum {
    public static Worker createWorker(Workers workers){

        switch (workers){
            case DOCTOR:
                return new Doctor();
            case TEACHER:
                return new Teacher();
            case FARMER:
                return new Farmer();
        }
        return null;
    }
}
