package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookSevice {
    void saveBook(Book book);
    void deleteBookById(Integer id);
    void updateBook(Book book);
    Book queryBookById(Integer id);
    List<Book> queryBooks();
    Page<Book> queryBooksByPage(Integer pageNo, Integer pageSize);

}
