package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.queryUserById(4);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUsers() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.queryUsers();
            System.out.println(users);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryForMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
       try {
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           mapper.queryForMap().forEach((k,v)->{
               System.out.println(k);
               System.out.println(v);
               System.out.println("=================");
           });

       }finally {
           sqlSession.close();
       }
    }

    @Test
    public void saveUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "wwwaaaf", 0);
            userMapper.saveUser(user);
            System.out.println(user);

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(1,"makabaka",0));
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUserById(1);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public  void queryUserByNameOrSex(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.queryUserByNameOrSex("张三", 0);
            for (User user : users) {
                System.out.println(user);
            }

        } finally {
            sqlSession.close();
        }

    }
    @Test
    public  void queryUserByMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map=new HashMap<>();
            map.put("name","张三" );
            map.put("sex",0);
            List<User> users = mapper.queryUserByMap(map);
            for (User user : users) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void queryUserLikeName(){
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.queryUserLikeName("三");
//            users.forEach((user)-> System.out.println(user));

            users.forEach(System.out::println);

        }

    }
}