package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.constant.MessageConstant;
import com.atguigu.constant.RedisConstant;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.pojo.SetMeal;
import com.atguigu.pojo.TravelGroup;
import com.atguigu.service.SetMealService;
import com.atguigu.utils.QiniuUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/setMeal")
public class SetMealController {

    @Reference
    SetMealService setMealService;

    @Autowired
    JedisPool jedisPool;

    @RequestMapping("/upload")
    public Result upload(@RequestParam("imgFile") MultipartFile imgFile) {
        try {
            //获得文件的文件名
            String originalFilename = imgFile.getOriginalFilename();
            //生成uuid文件名
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFilename;
            QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, fileName);
            return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);

        }
    }

    @RequestMapping("/findAllTravelGroups")
    public Result findAllTravelGroups() {
        try {
            List<TravelGroup> travelGroups = setMealService.findAllTravelGroups();
            return new Result(true, MessageConstant.QUERY_TRAVELGROUP_SUCCESS, travelGroups);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELGROUP_FAIL);

        }
    }

    @RequestMapping("/add")
    public Result add(@RequestParam("ids") Integer[] ids, @RequestBody SetMeal setMeal) {
        try {
            setMealService.add(ids, setMeal);
            jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setMeal.getImg());
            return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
        }
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean) {
        try {
            PageInfo<SetMeal> setMealPageInfo = setMealService.findPage(queryPageBean);
            return new Result(true, MessageConstant.QUERY_SETMEALLIST_SUCCESS, setMealPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_SETMEALLIST_FAIL);
        }
    }

    @RequestMapping("/del")
    public Result del(Integer id) {
        try {
            setMealService.del(id);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage());
        }
    }

    @RequestMapping("/findItemById")
    public Result findItemById(@RequestParam("id") Integer id) {
        try {
            SetMeal setMeal = setMealService.findItemById(id);
            return new Result(true, MessageConstant.QUERY_SETMEAL_SUCCESS, setMeal);
        } catch (Exception e) {
            return new Result(false, MessageConstant.QUERY_SETMEALLIST_FAIL);
        }
    }

    @RequestMapping("/findCheckedTravelGroups")
    public Result findCheckedTravelGroups(@RequestParam("id") Integer id) {
        try {
            Integer[] ids = setMealService.findCheckedTravelGroups(id);
            return new Result(true, MessageConstant.QUERY_TRAVELGROUP_SUCCESS, ids);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_TRAVELGROUP_FAIL);

        }

    }
    @RequestMapping("/update")
    public Result update(@RequestParam("ids") Integer[] ids, @RequestBody SetMeal setMeal) {
        try {
            setMealService.update(setMeal, ids);
            return new Result(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");

        }
    }
    @RequestMapping("/delOldPicIdFromDB")
    public Result delOldPicIdFromDB(@RequestParam("imgUrl") String imgUrl) {
        try {
            jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_DB_RESOURCES,imgUrl);
            return new Result(true, "图片更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"图片更新失败");

        }
    }

}
