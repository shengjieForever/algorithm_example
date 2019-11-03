package com.gsj.www.redis;

import redis.clients.jedis.Jedis;

public interface RedisPool {
    /**
     * 初始化
     * @param max
     * @param timeOut
     */
    void init(int max, long timeOut);

    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    Jedis browResource() throws Exception;

    /**
     * 释放连接
     * @param jedis
     */
    void release(Jedis jedis);
}
