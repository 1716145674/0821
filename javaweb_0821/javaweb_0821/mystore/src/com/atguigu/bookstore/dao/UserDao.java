package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.User;

public interface UserDao {
    User getUser(User user);
    boolean checkUser(User user);
    void saveUser(User user);
}
