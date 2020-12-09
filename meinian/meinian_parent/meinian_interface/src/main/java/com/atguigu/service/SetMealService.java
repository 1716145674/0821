package com.atguigu.service;

import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.SetMeal;
import com.atguigu.pojo.TravelGroup;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SetMealService {

    List<TravelGroup> findAllTravelGroups();

    void add(Integer[] ids, SetMeal setMeal);

    PageInfo<SetMeal> findPage(QueryPageBean queryPageBean);

    void del(Integer id);

    SetMeal findItemById(Integer id);

    Integer[] findCheckedTravelGroups(Integer id);

    void update(SetMeal setMeal, Integer[] ids);
}
