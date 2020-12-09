package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.User;
import com.atguigu.service.BookService;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringElTest {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @Test
    public void test1() {
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        bookService.saveEntity(new Book());
    }
    @Test
    public void test2() {
        bookService.saveEntity(new Book());
        userService.saveEntity(new User());
    }

}
