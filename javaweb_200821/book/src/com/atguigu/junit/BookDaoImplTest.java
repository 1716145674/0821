package com.atguigu.junit;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.CriteriaBook;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookDaoImplTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        int i = bookDao.saveBook(new Book(null, "玉蒲团", new BigDecimal("99.99"), "李四", 110, 300, "static/img/default.jpg"));
        if (i==0){
            System.out.println("添加图书失败");
        }else {
            System.out.println("添加图书成功");

        }
    }

    @Test
    public void updateBook() {
        int i = bookDao.updateBook(new Book(21, "金瓶梅", new BigDecimal("9.9"), "张三", 10, 30, "static/img/default.jpg"));
        if (i==0){
            System.out.println("修改图书失败");
        }else {
            System.out.println("修改图书成功");

        }
    }

    @Test
    public void deleteBookById() {
        int i = bookDao.deleteBookById(10);
        if (i==0){
            System.out.println("删除图书失败");
        }else {
            System.out.println("删除图书成功");

        }
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        books.forEach(System.out::println);
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(21);
        System.out.println(book);
    }
    @Test
    public void queryForPageItems(){
        List<Book> books = bookDao.queryForPageItems(5, 5);
        books.forEach(System.out::println);
    }
    @Test
    public void queryForPageTotalCount(){

    }
    @Test
    public void queryWithCriteriaBook(){
        CriteriaBook criteriaBook = new CriteriaBook(100d,null);
        List<Book> books = bookDao.queryWithCriteriaBook(criteriaBook);
        System.out.println(books.size());
        books.forEach(System.out::println);
    }

}