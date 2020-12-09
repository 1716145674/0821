package com.zqq.singleton.hungry;

/*
 * 饿汉式单例模式（静态变量）\
 * 优点：简单 类装载时就完成了实例的创建 避免了多线程问题
 * ?类加载 加载 -》链接（校验 ，准备，解析）-》初始化
 * ? 什么时候会发生类加载
 *   具体见 https://blog.csdn.net/wanghao112956/article/details/101194342
 *   1.通过new（）的构造器创建对象
 *   2.访问类的静态变量时  类名.静态属性名
 *   3.访问类的静态方法  类名.静态方法名
 *   4.反射 ，Class.forName(String className)
 *           对象.getClass()
 *           类名.Class
 *   5.初始化一个类的子类（会首先初始化子类的父类）
 *      父类的静态属性/静态代码块 ——》子类的静态属性/静态代码块——》
 *      父类的构造器——》子类的构造器
 *   6.虚拟机启动时，定义了main（）方法的类
 *
 * 缺点： 不用时 ，造成内存浪费
 *
 * 总结：可用 ，可能造成内存浪费
 * */
public class Type1 {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton==singleton1);
        System.out.println("singleton.hashCode()="+singleton.hashCode());
        System.out.println("singleton1.hashCode()="+singleton1.hashCode());
    }
}

class Singleton {
    //1.构造器私有化，外部不能new
    private Singleton() {

    }

    //2.在类的内部创建对象实例
    // 加上private 是让外部不能通过类名去调用此对象
    // final 修饰的对象表示此对象是无法重新赋值
    private static final Singleton singleton = new Singleton();

    //对外提供对象的过去方法
    public static Singleton getSingleton() {

        return singleton;
    }
}

//类加载的练习题
class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;



    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}

 class ClassLoadTest {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
/*
* 分析：
    SingleTon.getInstance()，调用静态方法，触发SingleTon类加载。
    SingleTon类加载初始化，按顺序初始化静态变量。
    先执行private static SingleTon singleTon = new SingleTon(); ，调用构造器后，count1，count2均为1；
    按顺序执行 public static int count1; 没有赋值，所以count1依旧为1；
    按顺序执行 public static int count2 = 0;所以count2变为0
    * */
//变种
class SingleTon1 {
    private static SingleTon1 singleTon1 = new SingleTon1();
    public static int count1;
    public static int count2 = 1;

    ////   静态代码块的执行是在初始化之后执行
    static {
        count1++;
        count2++;
    }

    private SingleTon1() {
//        count1++;
//        count2++;
    }

    public static SingleTon1 getInstance() {
        return singleTon1;
    }
}

class ClassLoadTest1 {
    public static void main(String[] args) {
        SingleTon1 singleTon = SingleTon1.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}