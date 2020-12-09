package com.atguigu.dao;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.CriteriaBook;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return
     */
    public int saveBook(Book book);

    /**
     * 修改图书
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 查询全部图书
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查询指定编号的图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);
    /**
     * 查询分页中，一页的数据
     *
     * @param begin
     *            起始索引
     * @param size
     *            数据的长度
     * @return 查询返回的数据集合<br/>
     *         如果查询失败返回null
     */
    public List<Book> queryForPageItems(long begin, long size);

    /**
     * 查询总的记录数
     *
     * @return
     */
    public Object queryForPageTotal();
    /**
     * 查询满足条件的记录
     * @return
     */
    public List<Book> queryWithCriteriaBook(CriteriaBook criteriaBook);

    /**
     * 在带有查询条件的查询分页中，一页的数据
     * @param begin
     * @param size
     * @param criteriaBook
     * @return
     */
    public List<Book> queryForPageItemsWithCriteriaBook(long begin, long size, CriteriaBook criteriaBook);
}
