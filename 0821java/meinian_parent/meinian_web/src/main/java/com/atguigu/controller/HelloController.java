package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloController {
    @Reference(check = false)
    HelloService helloService;

    @RequestMapping("/name")
    @ResponseBody
    public String getName() {
        return helloService.showName();
    }
}
