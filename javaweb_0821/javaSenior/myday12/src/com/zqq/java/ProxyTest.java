package com.zqq.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        ProxyedClass proxyedClass = new ProxyedClass();
        ProxyInterface instance = (ProxyInterface) ProxyClass.getProxyInstance(proxyedClass);
        instance.proxyStringMethod("代理者启动后调用被代理者的方法");
        instance.proxyVoidMethod();

        AjFactory ajFactory = new AjFactory();
        ClothFactory proxyInstance = (ClothFactory) ProxyClass.getProxyInstance(ajFactory);
        proxyInstance.produceCloth();


    }
}

interface ProxyInterface {
    void proxyVoidMethod();

    String proxyStringMethod(String string);
}

class ProxyedClass implements ProxyInterface {

    @Override
    public void proxyVoidMethod() {
        System.out.println("调用被代理者的无参方法");
    }

    @Override
    public String proxyStringMethod(String string) {
        System.out.println("调用被代理者的有参方法");

        return string;
    }
    public  void  test(){

    }


}

class ProxyClass {
    public static Object getProxyInstance(Object obj) {
//        MyInvocationHandle handle = new MyInvocationHandle();
//        handle.setProxyedInstance(obj);
//        Proxy proxy =Proxy.getProxyClass(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handle);
//        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handle);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new MyInvocationHandle1(obj));

    }
}

class MyInvocationHandle implements InvocationHandler {
    Object obj;

    public void setProxyedInstance(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValuse = method.invoke(obj, args);
        return returnValuse;
    }
}

class MyInvocationHandle1 implements InvocationHandler {
    Object obj;

    public MyInvocationHandle1(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValuse = method.invoke(obj, args);
        return returnValuse;
    }
}



