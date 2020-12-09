package com.atguigu.mapper;

import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookMapper {
    List<Book> getBooks();
}
