package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static <T> T getProxyInstance(T target ,InvocationHandler invocationHandler){

        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler);


    }
}
