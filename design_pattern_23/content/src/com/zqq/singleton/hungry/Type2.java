package com.zqq.singleton.hungry;

public class Type2 {
    public static void main(String[] args) {

        Singleton1 singleton = Singleton1.getSingleton();
        Singleton1 singleton1 = Singleton1.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton==singleton1);
        System.out.println("singleton.hashCode()="+singleton.hashCode());
        System.out.println("singleton1.hashCode()="+singleton1.hashCode());
    }
}
class Singleton1 {
    //1.构造器私有化，外部不能new
    private Singleton1() {

    }

    //2.在类的内部创建对象引用
    // 加上private 是让外部不能通过类名去调用此对象
    // final 修饰的对象表示此对象是无法重新赋值
    private static final Singleton1 singleton;

    //将对象的创建放到静态代码块中 同第一种差不多
    static {
        singleton = new Singleton1();
    }
    //对外提供对象的过去方法
    public static Singleton1 getSingleton() {

        return singleton;
    }
}

