package com.atguigu.pojo;

import org.springframework.stereotype.Component;

@Component
public class Calculator  implements Calculate{
    @Override
    public int add(int num1, int num2) {
        int result=num1+num2;
        return result;
    }

    @Override
    public int add(int num1, int num2, int num3) {
        int result=num1+num2+num3;
        return result;
    }

    @Override
    public double div(double num1, double num2) {
        double result=num1/num2;
        return result;
    }
}
