package com.atguigu.factory.dynamic_proxy;

import com.atguigu.factory.static_proxy.AppleFan;
import com.atguigu.factory.static_proxy.BuyPhone;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static Object createProxy(Object target) {
        /**
         * Proxy 是反射中的一个工具类 可以生成指定对象的代理对象实例
         * 方法 newProxyInstance（ClassLoader,Interfaces,InvocationHandler）有三个参数
         * 第一个参数表示 目标对象target的加载类
         * 第二个参数表示  目标对象所实现的所有接口的Class<?> 类型的接口</>
         * 第三个参数表示  目标对象执行方法与增强通知的代码 是接口InvocationHandler的一个实现类
         */
         return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 此方法是每次代理对象调用目标方法时都会执行一次的方法
                     * @param proxy 代理对象实例
                     * @param method 代理对象执行的方法的反射对象 Method
                     * @param args   代理对象执行方法所需要的可变参数
                     * @return  代理对象执行方法时的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //目标对象执行方法与增强通知的代码
                        //前置增强
                        Double money= (Double) args[0];
                        if (money<=6000d){
                            return  method.invoke(target,args);
                        }else {
                            System.out.println("妈的太贵了，不买了");
                        }
                        return -1;
                    }
                });

    }

    public static void main(String[] args) {
        BuyPhone proxy = (BuyPhone) createProxy(new AppleFan());
        proxy.buyIphone12(new Double(1000));
    }
}
