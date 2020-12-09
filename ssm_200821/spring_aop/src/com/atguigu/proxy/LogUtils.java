package com.atguigu.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)//在有多个切面作用于同一个目标是 默认依照字母顺序执行 可以使用order注解来人为的改变调用顺序，数字越小越优先
@Component
@Aspect
public class LogUtils {
    //切入点表达式的复用
    @Pointcut(value = "execution(public int  com.atguigu.pojo.Calculator1.*(..)))")
    public  void pointcut1() {
    }

    @Before(value = "execution(public int  com.atguigu.pojo.Calculator1.add(int, int))")
    public static void logBefore(JoinPoint joinPoint) {
        System.out.println("类：" + joinPoint.getTarget().toString() +
                ",执行了" + joinPoint.getSignature().getName() +
                "方法，参数是" + joinPoint.getArgs().toString());
    }
    public static void logAfterReturning(JoinPoint joinPoint,Object result) {

    }

    public static void logAfterThrowing(String target, String method, String args, String exception) {
        System.out.println("类：" + target + ",执行了" + method + "方法，参数是" + args + ",异常是" + exception);
    }
    @Around(value = "pointcut1()")
    public static Object Arount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result;
        try {
            try {
                System.out.println("环绕 前置");
                result = proceedingJoinPoint.proceed();
            } finally {
                System.out.println("环绕 后置");
            }
            System.out.println("环绕 返回");
            return result;
        }catch (Exception e){
            System.out.println("环绕 异常");
            throw  new RuntimeException(e);
        }
    }
}
