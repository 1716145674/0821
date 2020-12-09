package com.atguigu.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.HelloService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HelloServiceImpl  implements HelloService {

    @Override
    public String showName() {
        return "name";
    }
}
