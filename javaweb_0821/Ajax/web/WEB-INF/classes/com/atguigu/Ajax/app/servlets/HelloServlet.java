package com.atguigu.Ajax.app.servlets;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {

        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String user = servletRequest.getParameter("user");
        String passwrod = servletRequest.getParameter("passwrod");
        ServletContext servletContext = getServletConfig().getServletContext();
        String initUser = servletContext.getInitParameter("user");
        String initPassword = servletContext.getInitParameter("password");
        PrintWriter writer  = servletResponse.getWriter();
        if (user.equals(initUser)&&passwrod.equals(initPassword)){
            writer.println("Hello:"+ initUser);

        }else
            writer.println("Sorry:"+user +"  "+initUser+"是user");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
