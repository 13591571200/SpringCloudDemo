package com.jfp.datamiddle.redis.jedis;

import redis.clients.jedis.DebugParams;
import redis.clients.jedis.Jedis;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/19 14:25
 * @update 2020/12/19 14:25
 **/
public class Test {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("106.53.239.39");
        String user1 = jedis.debug(DebugParams.OBJECT("user"));
        System.out.println(user1);
        String set = jedis.set("user", "jiafupeng");
        System.out.println(set);
        String user = jedis.get("user");
        System.out.println(user);
        jedis.close();
    }
}
