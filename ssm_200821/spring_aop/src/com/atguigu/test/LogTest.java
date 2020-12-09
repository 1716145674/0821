package com.atguigu.test;

import com.atguigu.pojo.Calculate;
import com.atguigu.pojo.Calculator;
import com.atguigu.pojo.Calculator1;
import com.atguigu.proxy.MyInvocationHandler;
import com.atguigu.proxy.ProxyTest;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LogTest {
    @Autowired
    Calculator1 calculator;
    @Test
    public void test() {
        calculator.add(1,1);
    }
}
