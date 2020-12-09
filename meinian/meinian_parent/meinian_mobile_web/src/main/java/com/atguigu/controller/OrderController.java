package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.constant.RedisMessageConstant;
import com.atguigu.entity.Result;
import com.atguigu.pojo.Order;
import com.atguigu.service.OrderService;
import com.atguigu.utils.SMSUtils;
import com.atguigu.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    JedisPool jedisPool;

    @Reference
    OrderService orderService;

    /**
     * 预约发送验证码
     */
    @RequestMapping("/sendShortMessage")
    public Result sendShortMessage(String telephone) {
        try {
//            String validateCode = ValidateCodeUtils.generateValidateCode4String(4);
//            SMSUtils.sendShortMessage(telephone,validateCode);
            jedisPool.getResource().setex(telephone+ RedisMessageConstant.SENDTYPE_ORDER,5*60,"123456");
            return new Result(true,"验证码发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/saveOrder")
    public Result orderSetMeal(@RequestBody Map<String,Object> orderInfo,Integer id) {
        try {
            Order order=orderService.saveOrder(orderInfo,id);
            return new Result(true, MessageConstant.ORDER_SUCCESS,order);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }
    @RequestMapping("/findById")
    public Result findById(Integer id) {
        try {
            Map<String,Object> map=orderService.findById(id);
            System.out.println(map.get("orderDate"));
            return new Result(true, MessageConstant.QUERY_ORDER_SUCCESS,map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_ORDER_FAIL);
        }
    }

}
