package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookSevice;
import com.atguigu.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping(value = "/book")
@Controller
public class BookController {
    @Autowired
    BookSevice bookSevice;

    /**
     * 分页展示所有的图书信息
     */
    @RequestMapping(value = "/list")
    public String listBooks(String pageNo, String pageSize, Map<String, Object> map, HttpSession session) {
        Integer pageNoNum = WebUtils.parseString(pageNo);
        Integer pageSizeNum = WebUtils.parseString(pageSize);
        Page<Book> bookPage = bookSevice.queryBooksByPage(pageNoNum, pageSizeNum);

        bookPage.setUrl(session.getServletContext().getContextPath() + "/book/list");

        map.put("page", bookPage);
        return "bookList";
    }

    @RequestMapping(value = "/delete")
    public String delete(String pageNo, String pageSize, String id) {
        Integer idNum = WebUtils.parseString(id);
        bookSevice.deleteBookById(idNum);
        return "redirect:/book/list?pageNo=" + pageNo;
    }

    @RequestMapping(value = "/insert")
    public String insert(Book book) {
        bookSevice.saveBook(book);
        return "redirect:/book/list?pageNo=" + Integer.MAX_VALUE;
    }

    @RequestMapping(value = "/getBook")
    public String getBook(String pageNo,String id,Map<String,Object> map) {
        Integer idNum = WebUtils.parseString(id);
        Book book = bookSevice.queryBookById(idNum);
        map.put("book",book);
        return "forward:/book/bookEdit.jsp?pageNo="+pageNo;
    }
    @RequestMapping(value = "/update")
    public String update(Book book,String pageNo) {
        bookSevice.updateBook(book);
        return "redirect:/book/list?pageNo=" + pageNo;

    }

}
