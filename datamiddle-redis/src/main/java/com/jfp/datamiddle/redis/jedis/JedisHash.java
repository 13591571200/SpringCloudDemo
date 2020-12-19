package com.jfp.datamiddle.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/19 14:35
 * @update 2020/12/19 14:35
 **/
public class JedisHash {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("106.53.239.39");
        Long user = jedis.del("user");
        System.out.println(user);
        Long hset = jedis.hset("user", "name", "jiafupeng");
        System.out.println(hset);
        String hget = jedis.hget("user", "name");
        System.out.println(hget);
    }
}
