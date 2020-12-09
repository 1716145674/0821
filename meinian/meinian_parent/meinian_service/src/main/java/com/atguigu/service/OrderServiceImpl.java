package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.constant.OrderConstant;
import com.atguigu.constant.RedisMessageConstant;
import com.atguigu.dao.MemberMapper;
import com.atguigu.dao.OrderMapper;
import com.atguigu.dao.OrderSettingMapper;
import com.atguigu.pojo.*;
import com.atguigu.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderService.class)
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderSettingMapper orderSettingMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    JedisPool jedisPool;
    @Autowired
    OrderMapper orderMapper;

    /**
     * 实现订单保存
     */
    @Override
    public Order saveOrder(Map<String, Object> orderInfo, Integer id) throws Exception {
        //0 验证验证码是否正确
        String telephone = (String) orderInfo.get("telephone");

        String validateCode = (String) orderInfo.get("validateCode");
        if (validateCode==null||validateCode==""){
            throw new RuntimeException("验证码错误，请重新输入");
        }
        String key = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_ORDER);
        if ( key== null||!validateCode.equals(key)) {
            throw new RuntimeException("验证码错误，请重新输入");
        }
        //1.验证用户选取的日期是否可以预约
        //得到前端传过来的日期
        String orderDateStr = (String) orderInfo.get("orderDate");
        Date orderDate = DateUtils.parseString2Date(orderDateStr);
        //判断此日期在数据库中是否有记录
        OrderSettingExample orderSettingExample = new OrderSettingExample();
        orderSettingExample.createCriteria().andOrderdateEqualTo(orderDate);
        List<OrderSetting> orderSettings;
        if ((orderSettings = orderSettingMapper.selectByExample(orderSettingExample)).size() == 0) {
            throw new RuntimeException("此日期不在预约范围内，请重新选择日期");
        }
        //2.验证用户选取的日期的预约人数是否已满
        OrderSetting orderSetting = orderSettings.get(0);
        if (orderSetting.getReservations() == orderSetting.getNumber()) {
            throw new RuntimeException("此日期的预约人数已满，请重新选择日期");
        }
        //3.验证用户是否是会员 是会员直接添加，不是会员根据填写的信息自动生成会员
        //获得前端传过来的用户的身份证号，作为识别会员的id
        String idCard = (String) orderInfo.get("idCard");
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andIdcardEqualTo(idCard);
        List<Member> members = memberMapper.selectByExample(memberExample);
        String name = (String) orderInfo.get("name");
        String sex = (String) orderInfo.get("sex");
        Order order = null;
        if (members.size() == 0) {
            Member member = new Member(null, name, sex, idCard, telephone, new Date(), null, null, null, null);
            memberMapper.insertSelective(member);
            order = new Order(member.getId(), orderDate, OrderConstant.ORDER_TYPE_WEIXIN, OrderConstant.ORDER_STATUS_UNGO, id);
            orderMapper.insertSelective(order);
        } else {
            //4.若不是会员判断是否是重复预约 同一人同一天 同一份套餐为重复预约
            MemberExample memberExample1 = new MemberExample();
            memberExample1.createCriteria().andIdcardEqualTo(idCard);
            List<Member> members1 = memberMapper.selectByExample(memberExample1);
            Integer memberId = members1.get(0).getId();

            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria().andMemberIdEqualTo(memberId)
                    .andOrderdateEqualTo(orderDate)
                    .andSetmealIdEqualTo(id);
            if (orderMapper.selectByExample(orderExample).size() == 1) {
                throw new RuntimeException("您已预约，请不要重复预约");
            }
            order = new Order(memberId, orderDate, OrderConstant.ORDER_TYPE_WEIXIN, OrderConstant.ORDER_STATUS_UNGO, id);
            orderMapper.insertSelective(order);
        }


        return order;
    }

    @Override
    public Map<String, Object> findById(Integer id) {

        return orderMapper.findById(id);
    }
}
