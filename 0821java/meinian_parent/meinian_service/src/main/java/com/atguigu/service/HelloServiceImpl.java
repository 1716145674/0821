package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(interfaceClass = HelloService.class)
public class HelloServiceImpl  implements HelloService{
    @Override
    public String showName() {
        return "name";
    }
}
