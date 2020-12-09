package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return 存在返回用户 不存在放回null
     */
    public User getUserByName(String name);
    /**
     * 根据用户名 密码查询用户
     * @param name 用户名
     * @param password 密码
     * @return 存在返回用户 不存在放回null
     */
    public User getUserByNameAndPassword(String name,String password);

    /**
     * 存储用户
     * @param user
     * @return
     */
    public int savUser(User user);

}
