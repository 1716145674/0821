package com.atguigu.spring.pojo;

public class Calculator implements Calculate {
    @Override
    public int add(int num1, int num2) {
        System.out.println("实现了执行了");
        return num1+num2;
    }
}
