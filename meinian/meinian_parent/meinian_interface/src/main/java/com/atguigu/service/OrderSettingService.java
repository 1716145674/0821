package com.atguigu.service;

import com.atguigu.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {

    void saveDataByUpload(List<OrderSetting> orderSettings);

    List<Map<String, Integer>> findLeftObj(Integer currentYear, Integer currentMonth);

    void updateNum(OrderSetting orderSetting);
}
