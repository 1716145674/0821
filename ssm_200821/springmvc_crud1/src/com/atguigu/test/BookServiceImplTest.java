package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookSevice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = "classpath:springmvc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceImplTest {
    @Autowired
    BookSevice bookSevice;

    @Test
    public void saveBook() {
        bookSevice.saveBook(new Book(null, "金瓶梅", "范仲淹", new BigDecimal("100"), 100, 20));
    }

    @Test
    public void deleteBookById() {
        bookSevice.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookSevice.updateBook(new Book(21, "西厢记", "范仲淹", new BigDecimal("100"), 100, 20));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookSevice.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookSevice.queryBooks().forEach(System.out::println);
    }
    @Test
    public void queryBooksByPage() {
        Page<Book> bookPage = bookSevice.queryBooksByPage(null, null);
        bookPage.getItems().forEach(System.out::println);
    }
}