package com.atguigu.webapp.dao;


import com.atguigu.webapp.beans.Customer;
import com.atguigu.webapp.criteria.CriteriaCustomer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> getAll();
    public  void  save(Customer customer);
    public  Customer get(Integer id);
    public  void  delete(Integer id);
    public long getCountByName(String name);
    public  List<Customer> getListForCriteriaCustomer(CriteriaCustomer criteriaCustomer);
    public void update(Customer customer);

}
