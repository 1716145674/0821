package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.SetMealMapper;
import com.atguigu.dao.SetMealTravelGroupMapper;
import com.atguigu.dao.TravelGroupMapper;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = SetMealService.class)
@Transactional
public class SetMealServiceImpl implements SetMealService {

    @Autowired
    SetMealMapper setMealMapper;

    @Autowired
    TravelGroupMapper travelGroupMapper;

    @Autowired
    SetMealTravelGroupMapper setMealTravelGroupMapper;

    @Override
    public List<TravelGroup> findAllTravelGroups() {
        TravelGroupExample travelGroupExample = new TravelGroupExample();
        List<TravelGroup> travelGroups = travelGroupMapper.selectByExample(travelGroupExample);
        return travelGroups;
    }

    @Override
    public void add(Integer[] ids, SetMeal setMeal) {
        setMealMapper.insert(setMeal);
        //根据setMealId和ids批量插入
        setMealTravelGroupMapper.batchInsert(ids, setMeal.getId());
    }

    @Override
    public PageInfo<SetMeal> findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());

        SetMealExample setMealExample = new SetMealExample();
        if (queryPageBean.getQueryString() != null && queryPageBean.getQueryString().trim() != "") {

            SetMealExample.Criteria criteria = setMealExample.createCriteria();
            criteria.andCodeEqualTo(queryPageBean.getQueryString());

            SetMealExample.Criteria criteria1 = setMealExample.createCriteria();
            criteria1.andNameLike("%" + queryPageBean.getQueryString() + "%");

            setMealExample.or(criteria1);

            SetMealExample.Criteria criteria2 = setMealExample.createCriteria();
            criteria2.andHelpcodeEqualTo(queryPageBean.getQueryString());

            setMealExample.or(criteria2);
        }

        List<SetMeal> setMeals = setMealMapper.selectByExample(setMealExample);

        PageInfo<SetMeal> setMealPageInfo = new PageInfo<>(setMeals);

        return setMealPageInfo;
    }

    @Override
    public void del(Integer id) {
        setMealMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SetMeal findItemById(Integer id) {
        return setMealMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer[] findCheckedTravelGroups(Integer id) {
        Integer[] ids=setMealTravelGroupMapper.findCheckedTravelGroups(id);
        return ids;
    }

    @Override
    public void update(SetMeal setMeal, Integer[] ids) {
        setMealMapper.updateByPrimaryKey(setMeal);

        setMealTravelGroupMapper.deleteItemsByTravelGroupId(setMeal.getId());

        setMealTravelGroupMapper.batchInsert(ids,setMeal.getId());
    }

}
