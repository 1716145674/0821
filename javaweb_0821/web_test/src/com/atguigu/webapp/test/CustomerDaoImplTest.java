package com.atguigu.webapp.test;

import com.atguigu.webapp.beans.Customer;
import com.atguigu.webapp.criteria.CriteriaCustomer;
import com.atguigu.webapp.dao.CustomerDao;
import com.atguigu.webapp.daoimpl.CustomerDaoImpl;
import org.junit.Test;

import java.util.List;

public class CustomerDaoImplTest  {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Test
    public void testSave(){
        customerDao.save(new Customer("rose","beijing","342563616"));
    }
    @Test
    public void testGetId(){
        Customer customer = customerDao.get(1);
        System.out.println(customer);
    }
    @Test
    public void testGetAll(){
        List<Customer> all = customerDao.getAll();
       all.forEach(System.out::println);
    }
    @Test
    public void testDelete(){
        customerDao.delete(1);
    }
    @Test
    public void testgetAcount(){
        long aa = customerDao.getCountByName("rose");
        System.out.println(aa);
    }
    @Test
    public void testGetForListWithCriteria(){
        CriteriaCustomer criteriaCustomer =new CriteriaCustomer(null,null,null);
        List<Customer> list = customerDao.getListForCriteriaCustomer(criteriaCustomer);
        System.out.println(list.size());
        list.forEach(System.out::println);
    }


}
