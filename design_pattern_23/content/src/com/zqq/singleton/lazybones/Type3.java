package com.zqq.singleton.lazybones;

/**
 * 起到懒加载作用 ?（双重检查）同时解决线程安全问题
 *  if (singleton == null) {
 *             synchronized (Singleton.class) {
 *                 if (singleton == null) {
 *                     //需要把创建的对象传给引用
 *                     return singleton = new Singleton3();
 *                 }
 *             }
 *  }
 * 只有引用为空才进入会进行 同步锁前排队 否则直接返回对象 这样多次调用方法时只排队一次
 * 当进入到同步锁前时 只有前一个线程完成同步内容前释放了锁时 下一个线程才会进入锁
 * 但是在第二次if判断时发现引用已经不为空了 就会退出
 *
 * 总结 实际开发中 强烈推荐使用
 */
public class Type3 {
    public static void main(String[] args) {
        Singleton3 singleton = Singleton3.getSingleton();
        Singleton3 singleton3 = Singleton3.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton3);
        System.out.println(singleton == singleton3);
        System.out.println("singleton.hashCode()=" + singleton.hashCode());
        System.out.println("singleton3.hashCode()=" + singleton3.hashCode());

    }
}

class Singleton3 {
    //构造器私有化
    private Singleton3() {

    }

    //提供静态引用
    //volatile 可以将修改值立马更新到存储中，相当于一个轻量级的synchronized
    private static volatile Singleton3 singleton;

    //提供静态方法获得对象 同时加上了同步机制 解决
    public static Singleton3 getSingleton() {
        //当调用此方法时 引用为空时才会创建对象
        // 否则表示此次不是第一次调用此方法直接返回引用
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    //需要把创建的对象传给引用
                    return singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }

}