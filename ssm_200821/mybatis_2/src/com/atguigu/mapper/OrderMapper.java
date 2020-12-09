package com.atguigu.mapper;

import com.atguigu.pojo.Order;

public interface OrderMapper {

    Order queryOrderByIdForSimple(Integer id);

    Order queryOrderByIdByTwoStep(Integer id);
}
