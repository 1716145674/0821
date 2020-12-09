package com.atguigu.bookstore.service;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        if (userDao.checkUser(user) == false) {
            return null;
        } else
            return userDao.getUser(user);
    }

    @Override
    public boolean regist(User user) {
        if (userDao.checkUser(user)) {
            return false;
        } else {
            savaUser(user);
            return true;
        }
    }

    @Override
    public void savaUser(User user) {
        userDao.saveUser(user);
    }
}
