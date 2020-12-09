package com.atguigu.webapp.daoimpl;


import com.atguigu.webapp.beans.Customer;
import com.atguigu.webapp.criteria.CriteriaCustomer;
import com.atguigu.webapp.dao.BaseDao;
import com.atguigu.webapp.dao.CustomerDao;

import java.util.List;

public class CustomerDaoImpl extends BaseDao<Customer> implements CustomerDao {


    @Override
    public List<Customer> getAll() {
        String sql = "select * from customers";
        List<Customer> customers = QueryAll(sql);
        return customers;
    }

    @Override
    public void save(Customer customer) {
        String sql = "insert into customers values(default,?,?,?)";
        Update(sql, customer.getName(), customer.getAddress(), customer.getPhone());
    }

    @Override
    public Customer get(Integer id) {
        String sql = "select * from customers where id=?";
        return Query(sql, id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from customers where id=?";
        Update(sql, id);
    }

    @Override
    public long  getCountByName(String name) {
        String sql = "select count(*) from customers where name=?";
        return getValues(sql, name);
    }

    @Override
    public List<Customer> getListForCriteriaCustomer(CriteriaCustomer cc) {
        String sql="select id,name,address,phone from customers "+
                "where name like ? and address like ? and phone like ?";
        return  QueryAll(sql,cc.getName(),cc.getAddress(),cc.getPhone());
    }

    @Override
    public void update(Customer customer) {
        String sql="update customers set name=?,address=?,phone=? where id=?";
        Update(sql,customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());
    }


}
