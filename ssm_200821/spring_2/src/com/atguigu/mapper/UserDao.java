package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao  extends BaseDao<User>{
    @Override
    public void saveEntity(User user) {
        System.out.println("userdao"+user);
    }
}
