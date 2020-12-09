package com.atguigu.controller;

import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

//@RequestMapping("/book")
@Controller
public class RestfulController {
    @RequestMapping("/book/{id}")
    public String getBookById( @PathVariable(value = "id",required = false) String id){
        System.out.println("getBookById");
        return "redirect:/index.jsp";
    }
    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public String getBooks(){
        System.out.println("getBooks");
        return "redirect:/index.jsp";
    }
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String insertBook(){
        System.out.println("insertBook");
        return "redirect:/index.jsp";
    }

}
