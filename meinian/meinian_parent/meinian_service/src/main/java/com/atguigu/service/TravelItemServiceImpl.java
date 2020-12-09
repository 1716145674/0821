package com.atguigu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.constant.MessageConstant;
import com.atguigu.dao.TravelGroupTravelItemMapper;
import com.atguigu.dao.TravelItemMapper;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.TravelGroupTravelItemExample;
import com.atguigu.pojo.TravelGroupTravelItemKey;
import com.atguigu.pojo.TravelItem;
import com.atguigu.pojo.TravelItemExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = TravelItemService.class)
@Transactional
public class TravelItemServiceImpl implements TravelItemService {

    @Autowired
    TravelItemMapper travelItemMapper;
    @Autowired
    TravelGroupTravelItemMapper travelGroupTravelItemMapper;
    @Override
    public Result add(TravelItem travelItem) {

        try {
            travelItemMapper.insertSelective(travelItem);
            return new Result(true, MessageConstant.ADD_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            return new Result(false, MessageConstant.ADD_TRAVELITEM_FAIL);
        }

    }

    @Override
    public PageResult queryItemsWithPage(QueryPageBean queryPageBean) {


        //借助pageHelper进行分页查询
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());

        TravelItemExample travelItemExample = new TravelItemExample();

        if (queryPageBean.getQueryString()==null){
            queryPageBean.setQueryString("");
        }
        //添加的查询条件
        TravelItemExample.Criteria criteria = travelItemExample.createCriteria();
        criteria.andCodeEqualTo(queryPageBean.getQueryString());
        //创建第二个模糊查询条件
        TravelItemExample.Criteria criteria1 = travelItemExample.createCriteria();
        criteria1.andNameLike("%" + queryPageBean.getQueryString() + "%");
        //将第二个条件以or的方式加到查询中
        travelItemExample.or(criteria1);

        //获得分页且携带查询条件的所有的数据
        List<TravelItem> travelItems = travelItemMapper.selectByExample(travelItemExample);
        //根据生成的数据 获得pageinfo对象 可以获得此次page的所有的详细信息
        PageInfo<TravelItem> travelItemPageInfo = new PageInfo<>(travelItems);
        //返回封装好的pageResult
        return new PageResult(travelItemPageInfo.getTotal(), travelItems);


    }

    @Override
    public Result deleteItemById(String id) {
        try {
            //如果此记录存在其他依赖时无法删除
            TravelGroupTravelItemExample travelGroupTravelItemExample = new TravelGroupTravelItemExample();
            TravelGroupTravelItemExample.Criteria criteria = travelGroupTravelItemExample.createCriteria();
            criteria.andTravelitemIdEqualTo(Integer.parseInt(id));
            List<TravelGroupTravelItemKey> list = travelGroupTravelItemMapper.selectByExample(travelGroupTravelItemExample);
            if (list!=null&&list.size()>0){
                return new Result(false,"此项目有其他旅行社正在用");
            }
            //删除指定记录
            travelItemMapper.deleteByPrimaryKey(Integer.parseInt(id));
            return new Result(true,MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            return new Result(false,e.getMessage());
        }
    }

    //查找指定id的记录
    @Override
    public Result queryItemById(String id) {
        try {
            TravelItem travelItem = travelItemMapper.selectByPrimaryKey(Integer.parseInt(id));
            return new Result(true,"查询成功",travelItem);
        } catch (Exception e) {
            return new Result(false,e.getMessage());
        }
    }
    //跟新记录
    @Override
    public Result updateItem(TravelItem travelItem) {
        try {
            //此处使用updateByPrimaryKey 不用updateByPrimaryKeySelective 因为当前端传过来的为空时
            //需要把对象的属性赋值为空 而不是不做修改
            travelItemMapper.updateByPrimaryKey(travelItem);
            return new Result(true,MessageConstant.EDIT_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            return new Result(false,e.getMessage());
        }
    }
}
