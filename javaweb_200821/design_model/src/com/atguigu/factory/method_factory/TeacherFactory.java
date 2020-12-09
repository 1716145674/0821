package com.atguigu.factory.method_factory;

import com.atguigu.factory.bean.Teacher;
import com.atguigu.factory.bean.Worker;

public class TeacherFactory implements WorkerFactory {
    @Override
    public Worker create() {
        Teacher teacher=new Teacher();
        return teacher;
    }
}
