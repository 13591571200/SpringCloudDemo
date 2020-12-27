package com.jfp.datamiddle.test.aqstest;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/22 22:41
 * @update 2020/12/22 22:41
 **/
public class LockSupportTest {

    private static Thread thread = new Thread(new MThread());

    public static void main(String[] args) throws InterruptedException {
        thread.start();
        LockSupport.unpark(thread);
        LockSupport.unpark(thread);
        LockSupport.unpark(thread);
    }

    public static class MThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                LockSupport.park();
                System.out.println("Thread unpark 1");
                LockSupport.park();
                System.out.println("Thread unpark 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
