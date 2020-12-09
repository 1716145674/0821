package com.zqq.singleton.lazybones;

/**
 *
 * 起到懒加载作用
 * 同时解决线程安全问题 但是效率太低了
 *
 * 总结 实际开发中 不推荐使用
 */
public class Type2 {
    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.getSingleton();
        Singleton1 singleton1 = Singleton1.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton == singleton1);
        System.out.println("singleton.hashCode()=" + singleton.hashCode());
        System.out.println("singleton1.hashCode()=" + singleton1.hashCode());
    }
}

class Singleton1 {
    //构造器私有化
    private Singleton1() {

    }

    //提供静态引用
    private static Singleton1 singleton;

    //提供静态方法获得对象 同时加上了同步机制 解决
    public static synchronized Singleton1 getSingleton() {
        //当调用此方法时 引用为空时才会创建对象
        // 否则表示此次不是第一次调用此方法直接返回引用
        if (singleton == null) {
            //需要把创建的对象传给引用
            return singleton = new Singleton1();
        }
        return singleton;
    }

}