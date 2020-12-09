package com.atguigu.service;

import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.TravelItem;

public interface TravelItemService {
    /**
     * 自由行项目添加
     */
    Result add(TravelItem travelItem);

    /**
     * 分页查询travelItem表中所有的数据
     * @param queryPageBean
     */
    PageResult queryItemsWithPage(QueryPageBean queryPageBean);

    Result deleteItemById(String id);

    Result queryItemById(String id);

    Result updateItem(TravelItem travelItem);
}
