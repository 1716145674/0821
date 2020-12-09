package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInvocationHandler  implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Object result = method.invoke(target, args);
            return  result;
        } catch (Exception e) {
            LogUtils.logAfterThrowing(target.toString(),method.getName(), Arrays.asList(args).toString(),e.getMessage());
            throw  new RuntimeException(e);
        }

    }
}
