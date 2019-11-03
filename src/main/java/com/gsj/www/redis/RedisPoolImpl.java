package com.gsj.www.redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Redis的连接池
 */
public class RedisPoolImpl implements RedisPool{
    /**
     * 最大链接数量
     */
    private int max;
    /**
     * 超时时间
     */
    private long timeOut;
    /**
     * 空闲连接
     */
    private LinkedBlockingQueue<Jedis> free;
    /**
     * 繁忙连接
     */
    private LinkedBlockingQueue<Jedis> busy;
    /**
     * 用于计算，保证线程安全
     */
    private AtomicInteger atomicInteger;
    /**
     * 用于打印创建连接的次数
     */
    private AtomicInteger count;

    public RedisPoolImpl(){
        this.free = new LinkedBlockingQueue<Jedis>();
        this.busy = new LinkedBlockingQueue<Jedis>();
        this.atomicInteger = new AtomicInteger(0);
        this.count = new AtomicInteger(0);
    }

    /**
     * 连接池初始化
     * @param max
     * @param timeOut
     */
    public void init(int max, long timeOut) {
        for (int i = 0; i < 50; i++) {
            Jedis  jedis= new Jedis("127.0.0.1", 6379);
            this.free.offer(jedis);
            this.atomicInteger.getAndIncrement();
        }
        this.max = max;
        this.timeOut = timeOut;
        System.out.println("可用连接池的数量"+free.size());
    }


    /**
     * 获取连接
     * @return
     * @throws Exception
     */
    public Jedis browResource() throws Exception {
        long nowTime = System.currentTimeMillis();
        Jedis jedis = null;
        if (jedis == null) {

            //从空闲队列里面获取
            jedis = this.free.poll();
            this.atomicInteger.decrementAndGet();
            if (jedis != null) {
                //有连接,加入的繁忙的队列当中去
                busy.offer(jedis);
                return jedis;
            }

            //队列里面没有连接
            if (this.atomicInteger.get() < max) {

                if (this.atomicInteger.incrementAndGet() <= max) {
                    jedis= new Jedis("127.0.0.1", 6379);

                    System.out.println("jedis的连接数量：" + count.incrementAndGet());

                    this.busy.offer(jedis);
                    return jedis;

                }else {

                    this.atomicInteger.decrementAndGet();
                }

            }


            jedis = this.free.poll(timeOut - (System.currentTimeMillis() - nowTime), TimeUnit.MILLISECONDS);
            if (jedis != null){
                busy.offer(jedis);
                return jedis;

            }else {

            }

        }
        return null;
    }


    /***
     * 释放连接
     * @param jedis
     */
    public void release(Jedis jedis) {

    }

}
