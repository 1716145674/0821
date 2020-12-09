package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.OrderSettingMapper;
import com.atguigu.pojo.OrderSetting;
import com.atguigu.pojo.OrderSettingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.PUT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    OrderSettingMapper orderSettingMapper;

    /**
     * 根据上传的Excel中的数据 将数据保存到数据库中
     */
    @Override
    public void saveDataByUpload(List<OrderSetting> orderSettings) {
        //遍历每个每行记录
        for (OrderSetting orderSetting : orderSettings) {
            //先判断此次操作是插入还是跟新
            OrderSettingExample orderSettingExample = new OrderSettingExample();

            OrderSettingExample.Criteria criteria = orderSettingExample.createCriteria();

            criteria.andOrderdateEqualTo(orderSetting.getOrderdate());

            if (orderSettingMapper.countByExample(orderSettingExample) > 0) {

                orderSettingMapper.updateByExampleSelective(orderSetting, orderSettingExample);
            } else {
                orderSettingMapper.insertSelective(orderSetting);
            }
        }

    }

    /**
     * 根据年份，月份查询数据库中所有的数据
     */
    @Override
    public List<Map<String, Integer>> findLeftObj(Integer currentYear, Integer currentMonth) {
        //字符串拼接做模糊查询
        String month = currentMonth < 10 ? "0" + currentMonth : "" + currentMonth;
        String dateLike = currentYear + "-" + month + "-%";
        //查询数据库 找到所有匹配的数据
        List<OrderSetting> orderSettings = orderSettingMapper.selectOrderSettingLike(dateLike);
        //把数据封装到 list集合中
        List<Map<String, Integer>> list = new ArrayList<>();
        Map<String, Integer> map = null;

        for (OrderSetting orderSetting : orderSettings) {
            map = new HashMap<>();
            map.put("date", orderSetting.getOrderdate().getDate());
            map.put("number", orderSetting.getNumber());
            map.put("reservations", orderSetting.getReservations());
            list.add(map);
        }

        return list;
    }

    @Override
    public void updateNum(OrderSetting orderSetting) {
        OrderSettingExample orderSettingExample = new OrderSettingExample();
        OrderSettingExample.Criteria criteria = orderSettingExample.createCriteria();
        criteria.andOrderdateEqualTo(orderSetting.getOrderdate());
        if (orderSettingMapper.countByExample(orderSettingExample)==0){
            orderSettingMapper.insertSelective(orderSetting);
        }else {
            orderSetting.setReservations(null);
            orderSettingMapper.updateByExampleSelective(orderSetting,orderSettingExample);
        }
    }
}
