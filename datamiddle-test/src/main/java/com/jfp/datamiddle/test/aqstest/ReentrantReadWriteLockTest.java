package com.jfp.datamiddle.test.aqstest;

import java.time.LocalTime;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/26 23:33
 * @update 2020/12/26 23:33
 **/
public class ReentrantReadWriteLockTest {

    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        Thread.sleep(2000);
        System.out.println("writeLock");
        writeLock.unlock();

        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
    }

    public static class MThread implements Runnable{

        @Override
        public void run() {
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            readLock.lock();
            try {
                System.out.println("readLock");
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.unlock();

        }
    }
}
