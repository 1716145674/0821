package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    /**
     * 用户登录功能模块
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = WebUtils.copyParamToBean(new User(), request.getParameterMap());
        //查找用户名密码是否匹配数据库的数据
        if ((user=userService.login(user.getName(), user.getPassword()))!=null) {
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
        } else {
            request.setAttribute("errorMessage", "用户名或密码错误");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    /**
     * 用户注册功能模块
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取验证码输入框的值
        String code = request.getParameter("code");
        String username = request.getParameter("username");
        //获取验证码的值
        String  token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

        //验证验证码是否正确
        if (token!=null&&code.equalsIgnoreCase(token)) {
            //删除验证码的值
            request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
            //验证用户名是否可用
            if (userService.isExist(username)) {
                //用户名不可用 转发到注册页面
                request.removeAttribute("username");
                request.setAttribute("errorMessage", "【"+username + "】已存在。");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //注册成功重定向到成功页面
                userService.regist(WebUtils.copyParamToBean(new User(),request.getParameterMap()));
                response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
            }
        } else {
            //验证码错误 转发到注册页面
            request.setAttribute("errorMessage", "验证码错误！");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        // 移除Session对象中的用户信息
        request.getSession().removeAttribute("user");
        // 然后重定向到登录页面。或首页
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

}
