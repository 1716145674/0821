package com.atguigu.spring.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public  static  Object createProxyInstance(Object target){
       return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 代理对象每次调用代理方法method时都会执行的 方法
                     * @param proxy 要返回的代理对象
                     * @param method 代理对象执行的方法
                     * @param args  代理对象执行方法所需的参数
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        Object invoke = method.invoke(target, args);
                        //后置增强
                        return invoke;
                    }
                })  ;
    }

    public static void main(String[] args) {
        Calculate target=new Calculator();
        Calculate calculate = (Calculate) JdkProxyFactory.createProxyInstance(target);
        int add = calculate.add(1, 2);
        System.out.println(add);

    }
}
