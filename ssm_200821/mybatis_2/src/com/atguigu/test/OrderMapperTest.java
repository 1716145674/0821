package com.atguigu.test;

import com.atguigu.mapper.OrderItemMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OrderMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryOrderByIdForSimple() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            Order order = orderMapper.queryOrderByIdForSimple(3);
            System.out.println(order);
        }

    }
    @Test
    public void queryOrderByIdByTwoStep() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            Order order = orderMapper.queryOrderByIdByTwoStep(1);
            System.out.println(order.getId());
            System.out.println(order.getName());
            Thread.sleep(1000);
            System.out.println(order.getOrderItemList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void queryOrderItemByTwoStep() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            OrderItemMapper mapper =sqlSession.getMapper(OrderItemMapper.class);
            List<OrderItem> orderItems = mapper.queryOrderItemByTwoStep(1);
            System.out.println(orderItems);
//            System.out.println(order.getId());
//            System.out.println(order.getName());
        }

    }
}