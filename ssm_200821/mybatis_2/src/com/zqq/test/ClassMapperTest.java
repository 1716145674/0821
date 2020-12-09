package com.zqq.test;

import com.zqq.mapper.ClassMapper;
import com.zqq.pojo.Class;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryClassAndStudentsByClassId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
            Class aClass = classMapper.queryClassAndStudentsByClassId(1);
            System.out.println("班级号"+aClass.getId());
            System.out.println("班级名"+aClass.getName());
            aClass.getStudentList().forEach(System.out::println);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void queryClassAndStudentsByClassIdWithTwoStepResultMap() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
            Class aClass = classMapper.queryClassAndStudentsByClassIdWithTwoStep(2);
            System.out.println("班级号"+aClass.getId());
            System.out.println("班级名"+aClass.getName());
            aClass.getStudentList().forEach(System.out::println);
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void queryClassAndStudentsByClassIdAndLikeNameWithTwoStep() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
            Class aClass = classMapper.queryClassAndStudentsByClassIdAndLikeNameWithTwoStep(1);
            System.out.println("班级号"+aClass.getId());
            System.out.println("班级名"+aClass.getName());
            aClass.getStudentList().forEach(System.out::println);
        }finally {
            sqlSession.close();
        }
    }
}