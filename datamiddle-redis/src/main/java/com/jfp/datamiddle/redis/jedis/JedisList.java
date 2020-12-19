package com.jfp.datamiddle.redis.jedis;

import redis.clients.jedis.Jedis;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/19 14:38
 * @update 2020/12/19 14:38
 **/
public class JedisList {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("106.53.239.39");
        String lock = jedis.get("lock");
        System.out.println(lock);
        String set = jedis.set("lock", "111", "nx", "px", 100000);
        System.out.println(set);
    }
}
