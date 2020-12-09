package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.SetMealTravelGroupMapper;
import com.atguigu.dao.TravelGroupMapper;
import com.atguigu.dao.TravelGroupTravelItemMapper;
import com.atguigu.dao.TravelItemMapper;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = TravelGroupService.class)
@Transactional
public class TravelGroupServiceImpl implements TravelGroupService {

    @Autowired
    TravelGroupMapper travelGroupMapper;

    @Autowired
    TravelItemMapper travelItemMapper;

    @Autowired
    TravelGroupTravelItemMapper travelGroupTravelItemMapper;

    @Autowired
    SetMealTravelGroupMapper setMealTravelGroupMapper;
    @Override
    public List<TravelItem> findAllTravelItems() {
        TravelItemExample travelItemExample = new TravelItemExample();
        return travelItemMapper.selectByExample(travelItemExample);

    }

    @Override
    public void batchInsert(Integer[] ids, TravelGroup travelGroup) {
        travelGroupMapper.insert(travelGroup);

        travelGroupTravelItemMapper.batchInsert(ids, travelGroup.getId());
    }

    @Override
    public PageInfo<TravelGroup> findAllTravelGroupWithPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());

        TravelGroupExample travelGroupExample = new TravelGroupExample();
        if (queryPageBean.getQueryString() != null && queryPageBean.getQueryString().trim() != "") {
            TravelGroupExample.Criteria criteria = travelGroupExample.createCriteria();
            criteria.andCodeEqualTo(queryPageBean.getQueryString());

            TravelGroupExample.Criteria criteria1 = travelGroupExample.createCriteria();
            criteria1.andNameLike("%" + queryPageBean.getQueryString() + "%");

            TravelGroupExample.Criteria criteria2 = travelGroupExample.createCriteria();
            criteria2.andHelpcodeEqualTo(queryPageBean.getQueryString());

            travelGroupExample.or(criteria1);
            travelGroupExample.or(criteria2);
        }

        List<TravelGroup> travelGroups = travelGroupMapper.selectByExample(travelGroupExample);

        PageInfo<TravelGroup> travelGroupPageInfo = new PageInfo<>(travelGroups);

        return travelGroupPageInfo;
    }

    @Override
    public void deleteItemById(Integer id) {
        SetMealTravelGroupExample setMealTravelGroupExample = new SetMealTravelGroupExample();
        SetMealTravelGroupExample.Criteria criteria = setMealTravelGroupExample.createCriteria();
        criteria.andTravelgroupIdEqualTo(id);

        if (setMealTravelGroupMapper.countByExample(setMealTravelGroupExample) > 0) {
            throw new RuntimeException("存在关联的跟团游，无法删除");
        }
        travelGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TravelGroup findItemById(Integer id) {
        return travelGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer[] findCheckedTravelItems(Integer id) {
        return travelGroupTravelItemMapper.queryCheckedTravelItemIds(id);
    }

    @Override
    public void update(TravelGroup travelGroup, Integer[] ids) {

        travelGroupMapper.updateByPrimaryKey(travelGroup);

        travelGroupTravelItemMapper.deleteItemsByTravelGroupId(travelGroup.getId());

        travelGroupTravelItemMapper.batchInsert(ids,travelGroup.getId());
    }
}
