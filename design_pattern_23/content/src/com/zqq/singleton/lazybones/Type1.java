package com.zqq.singleton.lazybones;

/**
 * 起到懒加载作用
 * ？但是有线程问题
 * 当一个线程进入到
 * if (singleton == null) {
 *             //需要把创建的对象传给引用
 *             return singleton = new Singleton();
 *         }这个if中后没来得及创建对象失去了时间片
 *      另一个线程同时进入到这个if中 那么这两个线程都new了一个对象
 *      此时就出了错误；
 * 总结 实际开发中 无法使用这种模式
 */
public class Type1 {
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

class Singleton {
    //构造器私有化
    private Singleton() {

    }

    //提供静态引用
    private static Singleton singleton;

    //提供静态方法获得对象
    public static Singleton getSingleton() {
        //当调用此方法时 引用为空时才会创建对象
        // 否则表示此次不是第一次调用此方法直接返回引用
        if (singleton == null) {
            //需要把创建的对象传给引用
            return singleton = new Singleton();
        }
        return singleton;
    }

}