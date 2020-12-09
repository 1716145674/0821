package com.zqq.singleton.sources;

/**
 * Runtime 就是单例的 饿汉式
 * 什么时候用？
 * 1.一些频繁创建销毁的对象
 * 2.创建对象消耗资源过多 重量级对象
 * 3.经常使用的对象 工具类
 * 4.频繁访问数据库或文件的对象比如 数据源 session工厂
 */
public class Test {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

    }
}
