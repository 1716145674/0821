package com.atguigu.controller;

import com.atguigu.pojo.*;
import com.atguigu.service.OrderItemService;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderItemServiceImpl;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manager/orderServlet")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    OrderItemService orderItemService = new OrderItemServiceImpl();

    /**
     * 订单生成功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得登录的用户信息
        User user = (User) request.getSession().getAttribute("user");
        //获得购物车对象
        Car car = (Car) request.getSession().getAttribute("car");
        //生成订单添加到数据库中
        String orderId = orderService.addOrder(user.getId(), car);
        //转发到订单完成页面
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp?orderId=" + orderId);
        car.clear();
    }

    /**
     * 显示当前用户的订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得登录的用户信息
        User user = (User) request.getSession().getAttribute("user");
        //查找到用户的订单信息
        List<Order> orders = orderService.getOrdersByUserId(user.getId());

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }

    /**
     * 显示订单详情 根据订单号
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数订单号
        String orderId = request.getParameter("orderId");
        //根据订单号查找订单项目
        List<OrderItem> orderItems = orderService.getOrderItemsByOrderId(orderId);
        //在请求域中设置参数并转发
        request.setAttribute("orderItems", orderItems);
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request, response);
    }

    /**
     * 确认收货功能方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void changeOrderStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数订单号
        String orderId = request.getParameter("orderId");
        Integer status = WebUtils.parseInt(request.getParameter("status"), 0);
        //根据订单号修改订单的物流状态为2
        orderService.receiveGoodsByOrderId(orderId,status);

        //重定向会订单页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * \
     * 显示所有的订单信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得所有的订单
        List<Order> orders = orderService.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }
}
