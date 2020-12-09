package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping(value = {"/value1", "value2"})
    public String values() {
        System.out.println("测试 requestMapping 中的value属性");
        return "ok";
    }
    @RequestMapping(value = {"/params"},params ={"username!=abc","password=123"})
    public String params() {
        System.out.println("测试 requestMapping 中的params属性");
        return "ok";
    }
    //同样的在requestMapping 中的headers 和 method用法上和params相同
    @RequestMapping(value = {"/requestParams"})
    public String requestParams(HttpServletRequest request, String id, @RequestParam(name = "user",required = false,defaultValue = "tom") String username, String[] hobby, Person person) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");

        System.out.println(id);
        System.out.println(username);
        System.out.println(Arrays.asList(hobby));
        System.out.println(person);
        System.out.println("测试 方法参数中 中的普通参数属性");
        return "ok";
    }
    @RequestMapping(value = "/forward")
    public String forwardAndRedirect(){
        System.out.println("forward");
        return "forward:/pages/ok.jsp";
    }
    @RequestMapping(value = "/redirect")
    public String forwardAndRedirect1(){
        ModelMap  modelMap;
        Model model;
        Map map;
        System.out.println("redirect");
        return "redirect:/pages/ok.jsp";
    }

}
