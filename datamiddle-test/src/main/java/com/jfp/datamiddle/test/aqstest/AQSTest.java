package com.jfp.datamiddle.test.aqstest;

import com.jfp.datamiddle.test.threadtest.InterruptedTest;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/22 21:24
 * @update 2020/12/22 21:24
 **/
public class AQSTest {

    public static AQS aqs = new AQS();

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();
        Thread.sleep(1000);
        System.out.println("Main lock");
        reentrantLock.lock();
        System.out.println("Main locking end");
    }

    public static class MyThread implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("thread lock");
                reentrantLock.lock();
                System.out.println("thread lock end");
                Thread.sleep(3000000);
                reentrantLock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class AQS extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if(c == 0){
                compareAndSetState(c, c + arg);
                setExclusiveOwnerThread(current);
                return true;
            } else if(current == getExclusiveOwnerThread()){
                setState(c + arg);
                return true;
            }

            return false;
        }

        public void lock(){
            acquire(1);
        }
    }
}
