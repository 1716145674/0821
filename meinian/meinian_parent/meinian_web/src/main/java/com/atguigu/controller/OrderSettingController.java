package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.entity.Result;
import com.atguigu.pojo.OrderSetting;
import com.atguigu.service.OrderSettingService;
import com.atguigu.utils.DateUtils;
import com.atguigu.utils.POIUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderSetting")
public class OrderSettingController {

    @Reference
    OrderSettingService orderSettingService;
    @RequestMapping("/upload")
    public Result upload(MultipartFile excelFile){

        try {
            //每一行数据是一个String[] 每一行的一列是数组的一个属性
            List<String[]> strings = POIUtils.readExcel(excelFile);
            //将数组转化为OrderSetting 对象
            List<OrderSetting> orderSettings= new ArrayList<>();
            for (String[] string : strings) {
                OrderSetting orderSetting = new OrderSetting(new Date(string[0]),Integer.parseInt(string[1]));
                orderSettings.add(orderSetting);
            }
            orderSettingService.saveDataByUpload(orderSettings);
            return new Result(true, MessageConstant.UPLOAD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }
    @RequestMapping("/findLeftObj")
    public Result findLeftObj(Integer currentYear,Integer currentMonth){

        try {
            List<Map<String,Integer>> list=orderSettingService.findLeftObj(currentYear,currentMonth);
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
        }
    }
    @RequestMapping("/updateNum")
    public Result updateNum(@RequestBody OrderSetting orderSetting){
        try {
            orderSettingService.updateNum(orderSetting);
            return new Result(true,"可预约数更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
    }
}
