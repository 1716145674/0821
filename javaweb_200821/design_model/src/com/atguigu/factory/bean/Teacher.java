package com.atguigu.factory.bean;

public class Teacher  implements Worker{

    @Override
    public void work() {
        System.out.println("传道受业解惑！");
    }
}
