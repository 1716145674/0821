package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User queryUserById(Integer id);
    List<User> queryUsers();
    @MapKey("id")
    Map<Integer ,User > queryForMap();
    int saveUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer id);
    List<User> queryUserByNameOrSex(
            @Param("name") String name,
            @Param("sex") Integer sex);
    List<User> queryUserByMap(Map<String,Object> map);
    List<User> queryUserLikeName(String name);
}
