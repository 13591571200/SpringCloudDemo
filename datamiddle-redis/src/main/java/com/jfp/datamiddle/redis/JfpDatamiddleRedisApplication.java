package com.jfp.datamiddle.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/19 14:04
 * @update 2020/12/19 14:04
 **/
@SpringBootApplication
@EnableEurekaClient
public class JfpDatamiddleRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfpDatamiddleRedisApplication.class, args);
    }
}
