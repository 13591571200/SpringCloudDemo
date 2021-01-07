package com.jfp.datamiddle.test.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();

        Thread thread2 = new Thread(new MyThread());
        thread2.start();

        Thread.sleep(2000);
        countDownLatch.countDown();
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
