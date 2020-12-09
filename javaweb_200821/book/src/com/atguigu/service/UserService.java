package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    public int regist(User user);
    public User login(String name,String password);
    public boolean isExist(String name);
}
