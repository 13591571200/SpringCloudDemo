package com.jfp.datamiddle.test.aqstest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/26 23:33
 * @update 2020/12/26 23:33
 **/
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.writeLock().lock();
    }
}
