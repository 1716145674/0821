package com.atguigu.service;

import com.atguigu.pojo.Order;

import java.util.Map;

public interface OrderService {

    Order saveOrder(Map<String, Object> orderInfo,Integer id) throws Exception;

    Map<String, Object> findById(Integer id);
}
