package com.atguigu.mybatis.junit;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    InputStream resource;

    {
        try {
            resource = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    SqlSession sqlSession = sqlSessionFactory.openSession();


    @Test
    public void test1() throws IOException {

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.queryUserById(1);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.queryUsers();
            users.forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

}
