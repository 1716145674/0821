package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.SetMealMapper;
import com.atguigu.pojo.SetMeal;
import com.atguigu.pojo.SetMealExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = SetMealMobileService.class)
@Transactional
public class SetMealMobileServiceImpl  implements SetMealMobileService{

    @Autowired
    SetMealMapper setMealMapper;

    @Override
    public List<SetMeal> queryAllSetmeals() {
        SetMealExample setMealExample = new SetMealExample();
        return setMealMapper.selectByExample(setMealExample);
    }

    @Override
    public SetMeal findSetMealById(Integer id) {
        return setMealMapper.querySetMealDetailsById(id);
    }

    @Override
    public SetMeal findSetMealPartById(Integer id) {
        return setMealMapper.selectByPrimaryKey(id);
    }
}
