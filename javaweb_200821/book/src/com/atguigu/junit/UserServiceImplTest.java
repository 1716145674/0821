package com.atguigu.junit;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void regist() {
        userService.regist(new User(null,"lisi","lisi","lisi@qq.com"));
    }

    @Test
    public void login() {
        userService.login("lisi", "lisi");
    }

    @Test
    public void isExist() {
        System.out.println(userService.isExist("admin"));
    }
}