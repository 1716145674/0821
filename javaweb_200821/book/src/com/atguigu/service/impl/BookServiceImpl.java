package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.CriteriaBook;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
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
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        //创建page并设置属性
        Page<Book> page = new Page<>();
        //设置pageSize page模型的每页记录数
        page.setPageSize(pageSize);
        //设置总记录是
        Integer pageTotal = Integer.parseInt( String.valueOf(bookDao.queryForPageTotal()));
        page.setPageTotal(pageTotal);
        //设置总页数
        Integer pageCount=pageTotal/pageSize;
        if (pageTotal%pageSize!=0){
            pageCount++;
        }
        page.setPageCount(pageCount);
        //设置pageNo page模型的当前页面值 因为需要在set方法中判断其余pageCount的关系 所以需要在setPageCount后
        page.setPageNo(pageNo);
        //设置每页显示记录数
        page.setItems(bookDao.queryForPageItems((pageNo - 1) * pageSize, pageSize));

        return page;
    }

    @Override
    public Page<Book> PageWithCriteria(Integer pageNo, Integer pageSize, CriteriaBook criteriaBook) {
        //创建page并设置属性
        Page<Book> page = new Page<>();
        //设置pageNo page模型的当前页面值
        page.setPageSize(pageSize);
        //设置总记录是
        Integer pageTotal = bookDao.queryWithCriteriaBook(criteriaBook).size();
        page.setPageTotal(pageTotal);
        //设置总页数
        Integer pageCount=pageTotal/pageSize;
        if (pageTotal%pageSize!=0){
            pageCount++;
        }
        page.setPageCount(pageCount);
        //设置pageNo page模型的当前页面值 因为需要在set方法中判断其余pageCount的关系 所以需要在setPageCount后
        page.setPageNo(pageNo);
        //设置每页显示记录数
        page.setItems(bookDao.queryForPageItemsWithCriteriaBook((pageNo - 1) * pageSize, pageSize, criteriaBook));

        return page;
    }
}
