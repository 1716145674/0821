package com.atguigu.service;

import com.atguigu.pojo.SetMeal;

import java.util.List;

public interface SetMealMobileService {
    /**
     * 查询数据库中所有的套餐游
     */
    List<SetMeal> queryAllSetmeals();

    SetMeal findSetMealById(Integer id);

    SetMeal findSetMealPartById(Integer id);
}
