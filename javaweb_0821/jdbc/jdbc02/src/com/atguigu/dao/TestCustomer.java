package com.atguigu.dao;

import com.atguigu.javabean.Customer;
import org.junit.Test;

public class TestCustomer {

    CustomerDaoImpl cus=new CustomerDaoImpl();

    @Test
    public void test(){
        cus.insertCustomer(new Customer("张三","男",18,"123789","zs@qq.com"));
    }
    @Test
    public void test2(){
        System.out.println(cus.deleteCustomerById(1));
    }
    @Test
    public void test3(){

    }
}
