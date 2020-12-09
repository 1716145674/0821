package com.atguigu.test;

import com.atguigu.mapper.BookMapper;
import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.BookExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void countByExample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            BookExample bookExample=new BookExample();
            BookExample.Criteria criteria = bookExample.createCriteria();
            criteria.andPriceGreaterThanOrEqualTo(new BigDecimal("10"));
            criteria.andSalesLessThan(1000);
            bookExample.or().andNameEqualTo("怎样拐跑别人的媳妇");
            int count = bookMapper.countByExample(bookExample);
            System.out.println(count);

        }finally {

        }
    }

    @Test
    public void deleteByExample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            BookExample bookExample= new BookExample();
            BookExample.Criteria criteria = bookExample.createCriteria();
            bookMapper.deleteByExample(null);
        }finally {

        }
    }
    @Test
    public void setOrderByClause() {
        //删除销量最低的图书
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            BookExample bookExample = new BookExample();
            bookExample.setOrderByClause("sales");
            List<Book> books = mapper.selectByExample(bookExample);
            Book book = books.get(0);
            mapper.deleteByPrimaryKey(book.getId());
            sqlSession.commit();
        }finally {
        sqlSession.close();
        }
    }

    @Test
    public void deleteByPrimaryKey() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            BookExample bookExample = new BookExample();
            BookExample.Criteria criteria = bookExample.createCriteria();
            criteria.andStockLessThan(10);
            mapper.deleteByExample(bookExample);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            int i = mapper.insertSelective(new Book(null, "张三", "ao", new BigDecimal("111"), 111, 111));
            System.out.println(i);
            sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertSelective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            int i = mapper.insertSelective(new Book(null, "张三", "ao", new BigDecimal("111"), 111, 111));
            System.out.println(i);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectByExample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            BookExample bookExample = new BookExample();
            bookExample.createCriteria().andPriceGreaterThanOrEqualTo(new BigDecimal("10"))
                    .andSalesLessThan(1000);
            bookExample.or().andNameEqualTo("怎样拐跑别人的媳妇");
            List<Book> books = bookMapper.selectByExample(bookExample);
            for (Book book : books) {
                System.out.println(book);
            }

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectByPrimaryKey() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            Book book = mapper.selectByPrimaryKey(2);
            System.out.println(book);
        }finally {
            sqlSession.close();

        }
    }

    @Test
    public void updateByExampleSelective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            List<Book> books = mapper.selectByExample(null);
            for (Book book : books) {
                book.setPrice(book.getPrice().multiply(new BigDecimal("0.8")));
                mapper.updateByPrimaryKeySelective(book);
            }
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateByExample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

        }finally {

        }
    }

    @Test
    public void updateByPrimaryKeySelective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

        }finally {

        }
    }

    @Test
    public void updateByPrimaryKey() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

        }finally {

        }
    }
}