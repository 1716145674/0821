package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.CriteriaBook;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);

    /**
     * 修改图书
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 删除图书
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 查询图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部图书
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 根据参数得到page对象
     *
     * @param pageNo
     *            第几页数据
     * @param pageSize
     *            每页显示的记录数
     * @return 分页数据模型
     */
    public Page<Book> page(Integer pageNo, Integer pageSize);
    /**
     * 根据查询条件得到page对象
     *
     * @param pageNo
     *            第几页数据
     * @param pageSize
     *            每页显示的记录数
     * @return 分页数据模型
     */
    public Page<Book> PageWithCriteria(Integer pageNo, Integer pageSize, CriteriaBook criteriaBook);

}

