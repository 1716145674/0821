package com.atguigu.controller;

import com.atguigu.pojo.Car;
import com.atguigu.service.CarService;
import com.atguigu.service.impl.CarServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/manager/carServlet")
public class CarServlet extends BaseServlet {
    CarService carService = new CarServiceImpl();

    /**
     * 增加购物车的记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addBookItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //首页添加图书提示信息
        String name = request.getParameter("bookName");
        session.setAttribute("bookName", name);

        //先获得购物车，如果session中没有 则创建一个
        Car car = (Car) session.getAttribute("car");
        if (car == null) {
            //将购物车放到session中
            session.setAttribute("car", car = new Car());
        }
        //获得要添加的carItem
        Integer bookId = WebUtils.parseInt(request.getParameter("bookId"), 0);
        //调用service层car方法
        carService.addBook2CarById(car, bookId);
        //重定向到首页 request.getHeader("Referer")能够获得请求时的全部url 可以用来回退操作
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 根据id删除购物车中的商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求的参数
        Integer bookId = WebUtils.parseInt(request.getParameter("bookId"), 0);

        Car car = (Car) request.getSession().getAttribute("car");
        if (car!=null){
            car.deleteItem(bookId);
        }
        response.sendRedirect(request.getHeader("Referer"));

    }

    /**
     * 清空购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = (Car) request.getSession().getAttribute("car");
        if (car!=null){
            car.clear();
        }
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer bookId = WebUtils.parseInt(request.getParameter("bookId"), 0);
        Integer count = WebUtils.parseInt(request.getParameter("count"), 0);
        Car car = (Car) request.getSession().getAttribute("car");
        if (car!=null){
            car.updateItemCountById(bookId,count);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }
}
