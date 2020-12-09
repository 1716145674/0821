package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl  implements BookSevice {
    @Autowired
    BookDao bookDao;
    @Override
    public void saveBook(Book book) {
       bookDao.saveBook(book) ;
    }

    @Override
    public void deleteBookById(Integer id) {
      bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> queryBooksByPage(Integer pageNo, Integer pageSize) {
        Page<Book> bookPage = new Page<>();

        Integer pageTotal = bookDao.queryBooks().size();
        bookPage.setPageTotal(pageTotal);

        Integer pageCount=pageTotal/bookPage.getPageSize();
        if (pageTotal%bookPage.getPageSize()!=0){
            pageCount++;
        }
        bookPage.setPageCount(pageCount);

        bookPage.setPageNo(pageNo);
        bookPage.setPageSize(pageSize);

        bookPage.setItems(bookDao.queryBooksByPage(bookPage.getPageNo(),bookPage.getPageSize()));
        return bookPage;
    }
}
