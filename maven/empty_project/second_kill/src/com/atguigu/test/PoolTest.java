package com.atguigu.test;

import com.atguigu.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PoolTest {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPool();
        Jedis resource = jedisPool.getResource();
        System.out.println(resource);
        JedisPoolUtil.releaseResource(jedisPool,resource);
    }
}
