package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    //User类与数据中的表的映射接口 用来实现各种数据库操作
    User queryUserById(Integer id);
    public List<User> queryUsers();

    public int saveUser(User user);

    public int updateUser(User user);

    public int deleteUserById(Integer id);

}
