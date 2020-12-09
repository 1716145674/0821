package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    /**
     * 注册业务 保存用户信息
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public int regist(User user) {
        return userDao.savUser(user);
    }

    /**
     * 通过用户名密码验证登录状态
     *
     * @param name
     * @param password
     * @return 若返回值为true 则表示账号密码匹配成功 为false表示失败
     */
    @Override
    public User login(String name, String password) {
        return userDao.getUserByNameAndPassword(name, password);

    }

    /**
     * 通过用户名判断数据库中是否存在此用户
     *
     * @param name
     * @return 若返回值为true 则表示已存在此用户  为false表示不存在
     */
    @Override
    public boolean isExist(String name) {
        User user = userDao.getUserByName(name);
        if (user == null) {

            return false;
        } else
            return true;
    }
}
