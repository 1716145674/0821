package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public String list(Map<String,Object> map) {
        // 调用bookService.queryBooks()查询全部图书
        List<Book> books = bookService.queryBooks();
        // 保存到Request域中
        map.put("books",books);
        // 请求转发到/book/bookList.jsp
        return "bookList";
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String add(Book book) {
        // 调用bookService.saveBook()添加图书
        bookService.saveBook(book);
        // 重定向回图书列表管理页面
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        // 调用bookService.deleteBookById(id);
        bookService.deleteBookById(id);
        // 重定向到图书列表管理页面
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.PUT)
    public String update(Book book) {
        // 调用bookService.updateBook(book);修改图书信息
        bookService.updateBook(book);
        // 重定向到图书列表管理页面
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public String getBook(@PathVariable("id") Integer id,Map<String,Object> map) {
        // 把修改的图书信息保存到Request域中
        map.put("book",bookService.queryBookById(id));

        return "bookEdit";
    }

}
