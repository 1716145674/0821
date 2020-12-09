package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;
import com.atguigu.utils.BaseDao;

public class UserDaoImpl  extends BaseDao<User> implements UserDao {

    @Override
    public User getUserByName(String name) {
        String sql="select * from t_user where name=?";
        return queryOne(sql, name);
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        String sql="select * from t_user where name=? and password=?";
        return queryOne(sql,name,password);
    }

    @Override
    public int savUser(User user) {
        String sql="insert into t_user values(?,?,?,?)";
        return update(sql,null,user.getName(),user.getPassword(),user.getEmail());
    }
}
