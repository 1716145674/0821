package com.atguigu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
//添加 abstract 表示此类是抽象类不能实例化只用来让子类继承
public abstract class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决post请求的中文乱码问题
        request.setCharacterEncoding("UTF-8");
        //通过反射自动调用子类中的相关方法
        String actionMethod = request.getParameter("actionMethod");
        try {
            Method method = getClass().getDeclaredMethod(actionMethod, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
