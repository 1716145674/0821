package com.zqq.jdbc;

import com.zqq.bean.Customer;
import com.zqq.unit.JDBCUtil;
import org.junit.Test;

import java.util.List;

public class QueryTest {

    @Test
    public void test1() {
        String sql ="select id ,name,email,birth  from customers where id>?";
        List<Customer> customerList = JDBCUtil.getInstance(Customer.class, sql, 1);
        if(customerList!=null) {
            customerList.forEach(System.out::println);
        } else
            System.out.println("查无数据");
    }


}
