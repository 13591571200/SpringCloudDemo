package com.jfp.datamiddle.test.thread;

import java.time.LocalTime;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();

        System.out.println("Main join wait " + LocalTime.now());
        thread.join();
        System.out.println("Main end " + LocalTime.now());
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
