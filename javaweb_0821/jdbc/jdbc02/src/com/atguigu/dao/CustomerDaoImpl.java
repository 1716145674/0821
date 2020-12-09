package com.atguigu.dao;

import com.atguigu.javabean.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl extends BaseDaoByDbutils implements CustomerDao {
    @Override
    public int insertCustomer(Customer customer) {
        String sql = "insert into users values(default,?,?,?,?,?)";
        try {
            return update(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getPhone(), customer.getEmail());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteCustomerById(int id) {
        if (getCustomerById(id) != null) {
            String sql = "delete from users where id=?";
            try {
                return update(sql, id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public int updateCustomer(Customer customer) {
        int id = customer.getId();
        if (getCustomerById(id) != null) {
            deleteCustomerById(id);
            String sql = "insert into users values(?,?,?,?,?,?)";
            try {
                return update(sql, id, customer.getName(), customer.getGender(), customer.getAge(), customer.getPhone(), customer.getEmail());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "select * from users where id=?";
        try {
            return getBean(Customer.class, sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Customer> getCustomers() {
        String sql = "select * from users";
        try {
            return getBeans(Customer.class, sql, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
