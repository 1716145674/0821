package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
@ContextConfiguration(locations = "classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoImplTest {
    @Autowired
    BookDao bookDao;
    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,"金瓶梅","范仲淹",new BigDecimal("100"),100,20));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"玉蒲团","范仲淹",new BigDecimal("100"),100,20));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }
    @Test
    public void queryBooksByPage() {
        bookDao.queryBooksByPage(1,5).forEach(System.out::println);
    }

}