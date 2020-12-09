package com.zqq.singleton.enum_method;

/**
 * 还能防止反序列的重新创建新的对象
 * 推荐使用
 */
public class Type1 {
    public static void main(String[] args) {
        System.out.println(Singleton.INSTANCE == Singleton.INSTANCE);
    }
}
enum Singleton{
    INSTANCE;
}
