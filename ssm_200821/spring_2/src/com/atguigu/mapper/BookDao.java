package com.atguigu.mapper;

import com.atguigu.pojo.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public void saveEntity(Book book) {
        System.out.println("bookdao "+book);
    }
}
