package com.jfp.datamiddle.test;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/25 15:45
 * @update 2020/12/25 15:45
 **/
public class JustTest {

    private static Logger log = LoggerFactory.getLogger(JustTest.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Thread(new MThread()));
        executorService.execute(new Thread(new MThread()));
        executorService.execute(new Thread(new MThread()));

        System.out.println("end");

    }

    public static class MThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
