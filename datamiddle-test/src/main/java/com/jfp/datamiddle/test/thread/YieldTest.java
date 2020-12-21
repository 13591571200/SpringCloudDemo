package com.jfp.datamiddle.test.thread;

import java.time.LocalTime;

public class YieldTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();

        Thread thread2 = new Thread(new MyThread());
        thread2.start();
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i + " " + LocalTime.now());
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + " " + i + " yield " + LocalTime.now());
            }
        }
    }
}
