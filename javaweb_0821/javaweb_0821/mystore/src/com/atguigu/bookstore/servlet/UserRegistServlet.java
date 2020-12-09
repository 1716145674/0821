package com.atguigu.bookstore.servlet;

import com.atguigu.bookstore.beans.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/userRegistServlet")
public class UserRegistServlet extends HttpServlet {
    UserService userService;
    public UserRegistServlet() {
        userService = new UserServiceImpl();
    }

    protected void doPOST(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        boolean registOk = userService.regist(user);
        if (registOk){
            response.sendRedirect("/pages/user/regist_success.html");
        }else {
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }
}
