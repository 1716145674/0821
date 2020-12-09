package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.constant.RedisMessageConstant;
import com.atguigu.entity.Result;
import com.atguigu.pojo.SetMeal;
import com.atguigu.service.SetMealMobileService;
import com.atguigu.utils.SMSUtils;
import com.atguigu.utils.ValidateCodeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetMealMobileController {

    @Reference
    SetMealMobileService setMealMobileService;


    @RequestMapping("/getSetMeal")
    public Result getSetMeal() {
        try {
            List<SetMeal> setMeals = setMealMobileService.queryAllSetmeals();
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setMeals);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }

    @RequestMapping("/findSetMealById")
    public Result findSetMealById(Integer id) {
        try {
            SetMeal setMeal =setMealMobileService.findSetMealById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setMeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }
    @RequestMapping("/findSetMealPartById")
    public Result findSetMealPartById(Integer id) {
        try {
            SetMeal setMeal =setMealMobileService.findSetMealPartById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setMeal);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, MessageConstant.QUERY_SETMEAL_FAIL);
        }
    }



}
