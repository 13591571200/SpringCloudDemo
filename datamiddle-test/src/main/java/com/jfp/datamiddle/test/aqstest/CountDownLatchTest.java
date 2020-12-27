package com.jfp.datamiddle.test.aqstest;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/26 19:38
 * @update 2020/12/26 19:38
 **/
public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        Thread.sleep(2000);
        countDownLatch.countDown();
        countDownLatch.countDown();

    }


    public static class MThread implements Runnable{

        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + "run结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
