package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookService {
    void saveBook(Book book);
    void deleteBookById(Integer id);
    void updateBook(Book book);
    Book selectBookById(Integer id);
    List<Book> selectBooks();
}
