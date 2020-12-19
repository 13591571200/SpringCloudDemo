package com.jfp.datamiddle.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/19 12:19
 * @update 2020/12/19 12:19
 **/
@SpringBootApplication
@EnableEurekaServer
public class JfpDatamiddleEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JfpDatamiddleEurekaApplication.class, args);
    }
}
