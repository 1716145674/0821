package com.atguigu.dao;

import com.atguigu.javabean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    int insertCustomer(Customer customer) ;
    int deleteCustomerById(int id);
    int updateCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getCustomers();
}
