package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据传入的id的list集合查找用户
     */
    List<User> queryUserByIds( @Param("ids") List<Integer> ids);
    /**
     * 批量插入多个user
     */
    Integer insertManyUser(@Param("users") List<User> users);
    /*
       根据id查找用户对象
     */
    User queryUserById(Integer id);
}
