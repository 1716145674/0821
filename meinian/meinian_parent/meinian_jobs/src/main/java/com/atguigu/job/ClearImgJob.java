package com.atguigu.job;

import com.atguigu.constant.RedisConstant;
import com.atguigu.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class ClearImgJob {

    @Autowired
    JedisPool jedisPool;

    public void clearImg(){
        Jedis jedis = jedisPool.getResource();

        Set<String> imgs = jedis.sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        for (String img : imgs) {
            QiniuUtils.deleteFileFromQiniu(img);
            jedis.srem(RedisConstant.SETMEAL_PIC_RESOURCES,img);
        }


    }
}
