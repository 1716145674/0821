package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.beans.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 根据用户名和密码去数据库中查找对应的User对象
     * @param user
     * @return
     */
    @Override
    public User getUser(User user) {
        String sql="select * from users where username=?and password=?";
        User queryValue = Query(user.getClass(), sql, user.getUsername(), user.getPassword());
        return queryValue;
    }

    /**
     * 根据用户名去数据库中查找是否有对应的User对象
     * @param user
     * @return
     */
    @Override
    public boolean checkUser(User user) {
        String sql="select * from users where username=?";
        User queryValue = Query(user.getClass(), sql, user.getUsername());
        if (queryValue!=null) {
            return true;
        }else
            return false;
    }

    @Override
    public void saveUser(User user) {
        String sql="insert into users values(default,?,?,?)";
        Update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
