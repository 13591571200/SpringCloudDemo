package com.jfp.datamiddle.test.threadtest;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/20 11:03
 * @update 2020/12/20 11:03
 **/
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("哈哈");
        Thread thread = new Thread(threadGroup, new MyThread());
        thread.start();
        Thread.sleep(1000);
        System.out.println(threadGroup.activeCount());
        System.out.println("bb");

        Unsafe unsafe = Unsafe.getUnsafe();


    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("aa");
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            System.out.println(threadGroup);
        }
    }
}
