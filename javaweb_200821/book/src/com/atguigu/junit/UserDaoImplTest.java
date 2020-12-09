package com.atguigu.junit;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void getUserByName() {
        User admin = userDao.getUserByName("admin");
        if (admin==null){
            System.out.println("此用户不存在");
        }else {
            System.out.println("此用户已存在");

        }
        User admin1 = userDao.getUserByName("admin1");
        if (admin1==null){
            System.out.println("此用户不存在");
        }else {
            System.out.println("此用户已存在");

        }
    }

    @Test
    public void getUserByNameAndPassword() {
        User user = userDao.getUserByNameAndPassword("admin", "admin");
        if (user==null){
            System.out.println("此用户不存在");
        }else {
            System.out.println("此用户已存在");

        }
        User user1 = userDao.getUserByNameAndPassword("admin", "123789");
        if (user1==null){
            System.out.println("此用户不存在");
        }else {
            System.out.println("此用户已存在");

        }
    }

    @Test
    public void savUser() {
        int zhangsan = userDao.savUser(new User(null, "zhangsan", "666666", "zhangsan@qq.com"));
        System.out.println(zhangsan);
    }
}