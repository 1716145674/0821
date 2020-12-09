package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.TravelGroup;
import com.atguigu.pojo.TravelItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TravelGroupService {

    List<TravelItem> findAllTravelItems();

    void batchInsert(Integer[] ids, TravelGroup travelGroup);

    PageInfo<TravelGroup> findAllTravelGroupWithPage(QueryPageBean queryPageBean);

    void deleteItemById(Integer id);

    TravelGroup findItemById(Integer id);

    Integer[] findCheckedTravelItems(Integer id);

    void update(TravelGroup travelGroup, Integer[] ids);
}
