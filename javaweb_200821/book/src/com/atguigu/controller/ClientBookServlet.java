package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.CriteriaBook;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

@WebServlet(value = "/client/bookServlet")
public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    /**
     * 分页显示所有的记录
     *
     * @param request
     * @param response
     */
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //获得客户端传递过来的当前页面pageNo的值 若出错则为默认值0
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);

        //获得客户端传递过来的每页显示的记录数pageSize的值 若出错则为Page的默认值
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用service的方法获得封装了数据的page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        //设置page的url
        page.setUrl("client/bookServlet?actionMethod=page");

        //设置request域对象
        request.setAttribute("page", page);

        //转发到client/index.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);

    }

    /**
     * 带查询条件的分页页面查询方法
     *
     * @param request
     * @param response
     */
    public void queryWithCriteria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalAccessException {
        //得到查询条件的对象
        CriteriaBook criteriaBook = WebUtils.copyParamToBean(new CriteriaBook(), request.getParameterMap());

        //获得客户端传递过来的当前页面pageNo的值 若出错则为默认值0
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);

        //获得客户端传递过来的每页显示的记录数pageSize的值 若出错则为Page的默认值
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //调用service的方法获得封装了数据的page对象
        Page<Book> bookPage = bookService.PageWithCriteria(pageNo, pageSize, criteriaBook);

        //为bookPage添加url参数
        StringBuilder sb = new StringBuilder("client/bookServlet?actionMethod=queryWithCriteria");

        //追加添加参数
        Field[] criteriaBookFields = criteriaBook.getClass().getDeclaredFields();
        for (Field criteriaBookField : criteriaBookFields) {
            String name = criteriaBookField.getName();
            if (request.getParameter(name)!=null&&request.getParameter(name).length()>0){
                sb.append("&"+name+"="+request.getParameter(name));
            }
        }
        bookPage.setUrl(sb.toString());

        //设置request域对象
        request.setAttribute("page", bookPage);

        //转发到client/index.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);


    }


}
