package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//次注解= 在此类的每个方法上加上@ResponseBody + @Controller
@RestController
@RequestMapping("/travelItem")
public class TravelItemController {

    @Reference
    TravelItemService travelItemService;
    
    @RequestMapping("/add")
    public Result add(@RequestBody TravelItem travelItem){
        return  travelItemService.add(travelItem);
    }
    @RequestMapping("/showList")
    public PageResult showList(@RequestBody QueryPageBean queryPageBean){
        return travelItemService.queryItemsWithPage(queryPageBean);
    }

    @RequestMapping("/del")
    @PreAuthorize("hasAuthority('TRAVELITEM_DELETE')")
    public Result deleteById(@RequestParam(name = "id") String id){
        try {
             travelItemService.deleteItemById(id);
             return  new Result(true, MessageConstant.DELETE_TRAVELITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
    }
    @RequestMapping("/queryItemById")
    public Result queryItemById(@RequestParam(name = "id") String id){
        return travelItemService.queryItemById(id);
    }
    @RequestMapping("/update")
    public Result queryItemById(@RequestBody TravelItem travelItem){

        return travelItemService.updateItem(travelItem);
    }
}
