package com.atguigu.dao.test;

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
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null, 1234567, 123456, "那瓶梅", "0821", new BigDecimal("9999")));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21, 1234567, 123456,
                "活着", "余华", new BigDecimal("9999")));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(1));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }
}