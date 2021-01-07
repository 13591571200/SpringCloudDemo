package com.jfp.datamiddle.test.aqstest;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/26 22:47
 * @update 2020/12/26 22:47
 **/
public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();

    }

    public static class MThread implements Runnable{

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(2000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " release " + LocalTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
