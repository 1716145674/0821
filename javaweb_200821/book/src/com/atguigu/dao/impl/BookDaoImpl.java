package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.CriteriaBook;
import com.atguigu.utils.BaseDao;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update  t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql, id);
    }

    @Override
    public List<Book> queryBooks() {

        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book";
        return queryList(sql);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book where id=? ";
        return queryOne(sql,id);
    }

    @Override
    public List<Book> queryForPageItems(long begin, long size) {
        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book limit ?,? ";
        return queryList(sql,begin,size);
    }

    @Override
    public Object queryForPageTotal() {
        String sql="select count(*) from t_book ";
        return  queryForSingleOne(sql);
    }

    @Override
    public List<Book> queryWithCriteriaBook(CriteriaBook criteriaBook) {
        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book where price between ? and ? " +
                " and name like ? and author like ?";
        return queryList(sql,criteriaBook.getMinPrice(),criteriaBook.getMaxPrice(),criteriaBook.getName(),criteriaBook.getAuthor());
    }

    @Override
    public List<Book> queryForPageItemsWithCriteriaBook(long begin, long size, CriteriaBook criteriaBook) {
        String sql="select id,name,price,author,sales,stock,img_path imgPath from t_book where " +
                "price between ? and ? and name like ? and author like ?  order by price  limit ? , ?";
        return queryList(sql,criteriaBook.getMinPrice(),criteriaBook.getMaxPrice(),criteriaBook.getName(),criteriaBook.getAuthor(),begin,size);
    }
}
