package com.atguigu.Ajax.app.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "valiateUserName")
public class ValiateUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> userNames= Arrays.asList("aaa","bbb","ccc");
        String userName = request.getParameter("userName");
        String result=null;
        if (userNames.contains(userName)){
            result="<font color='red>该用户已存在'</font>";
        }else
            result="<font color='green>该用户可以使用'</font>";
            response.setContentType("text/html");
            response.getWriter().print(result);
    }


}
