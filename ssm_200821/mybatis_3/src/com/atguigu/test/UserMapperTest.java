package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryUserByIds() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            List<User> users = userMapper.queryUserByIds(ids);
            users.forEach(System.out::println);
        }

    }

    @Test
    public void insertManyUser() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = new ArrayList<>();
            users.add(new User(null, "aaa", 1));
            users.add(new User(null, "bbb", 0));
            users.add(new User(null, "ccc", 1));
            System.out.println(userMapper.insertManyUser(users));
            sqlSession.commit();
        }

    }
    public User queryOne(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.queryUserById(5);
        }
    }
    @Test
    public  void  testCache(){
        System.out.println(queryOne());
    }

}