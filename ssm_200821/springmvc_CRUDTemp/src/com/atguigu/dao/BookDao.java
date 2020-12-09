package com.atguigu.dao;

import com.atguigu.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface BookDao {
    int saveBook(Book book);
    int deleteBookById(Integer id);
    int updateBook(Book book);
    Book queryBookById(Integer id);
    List<Book> queryBooks();
    List<Book> queryBooksByPage(Integer pageNo,Integer pageSize);

}
