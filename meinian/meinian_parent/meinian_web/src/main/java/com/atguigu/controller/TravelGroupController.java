package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.TravelGroup;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelGroupService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/travelGroup")
public class TravelGroupController {

    @Reference
    TravelGroupService travelGroupService;

    @RequestMapping("/findAllTravelItems")
    public Result findAllTravelItems() {
        try {
            List<TravelItem> travelItems = travelGroupService.findAllTravelItems();
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, travelItems);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/add")
    public Result add(@RequestParam("ids") Integer[] ids, @RequestBody TravelGroup travelGroup) {
        try {
            travelGroupService.batchInsert(ids, travelGroup);
            return new Result(true, MessageConstant.ADD_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_TRAVELGROUP_FAIL);
        }
    }

    @RequestMapping("/findAllTravelGroupWithPage")
    public PageResult findAllTravelGroupWithPage(@RequestBody QueryPageBean queryPageBean) {
        try {
            PageInfo<TravelGroup> travelGroupPageInfo = travelGroupService.findAllTravelGroupWithPage(queryPageBean);
            return new PageResult(travelGroupPageInfo.getTotal(), travelGroupPageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/del")
    public Result del(@RequestParam("id") Integer id) {
        try {
            travelGroupService.deleteItemById(id);
            return new Result(true, MessageConstant.DELETE_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }

    }

    @RequestMapping("/findItemById")
    public Result findItemById(@RequestParam("id") Integer id) {
        try {
            TravelGroup travelGroup = travelGroupService.findItemById(id);
            return new Result(true, MessageConstant.QUERY_TRAVELGROUP_SUCCESS, travelGroup);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_TRAVELGROUP_FAIL);
        }
    }

    @RequestMapping("/findCheckedTravelItems")
    public Result findCheckedTravelItems(@RequestParam("id") Integer id) {
        try {
            Integer[] checkedTravelItems = travelGroupService.findCheckedTravelItems(id);
            return new Result(true, MessageConstant.QUERY_TRAVELITEM_SUCCESS, checkedTravelItems);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_TRAVELITEM_FAIL);
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestParam("ids") Integer[] ids, @RequestBody TravelGroup travelGroup) {

        try {
            travelGroupService.update(travelGroup, ids);
            return new Result(true, MessageConstant.EDIT_TRAVELGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_TRAVELGROUP_FAIL);

        }
    }
}
