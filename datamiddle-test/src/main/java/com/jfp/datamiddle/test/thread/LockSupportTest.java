package com.jfp.datamiddle.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportTest {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();
        Thread thread2 = new Thread(new MyThread());
        thread2.start();
        Thread.sleep(5000);
        reentrantLock.lock();
        Thread.sleep(10000);
        reentrantLock.unlock();
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            reentrantLock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        }
    }
}
