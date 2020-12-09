package com.atguigu.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private JedisPoolUtil() {

    }

    private static class JedisInstance {
        private static JedisPoolConfig poolConfig;

        static {
            poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(200);
            poolConfig.setMaxIdle(32);
            poolConfig.setMaxWaitMillis(100 * 1000);
            poolConfig.setBlockWhenExhausted(true);
            poolConfig.setTestOnBorrow(true);
        }

        public static final JedisPool POOLINSTACNE = new JedisPool(poolConfig, "192.168.137.128", 6379);

    }

    public static JedisPool getJedisPool() {
        return JedisInstance.POOLINSTACNE;
    }

    public static void releaseResource(JedisPool jedisPool, Jedis jedis) {
        jedisPool.returnResource(jedis);
    }
}
