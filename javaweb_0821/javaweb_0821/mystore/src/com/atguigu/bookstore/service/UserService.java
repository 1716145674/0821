package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.UserDaoImpl;

public interface UserService {
    User login(User user) ;
    boolean regist(User user);
    void savaUser(User user) ;

}
