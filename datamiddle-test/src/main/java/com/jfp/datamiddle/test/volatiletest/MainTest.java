package com.jfp.datamiddle.test.volatiletest;

public class MainTest {

    private volatile static boolean bool = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Thread0());
        thread.start();

        Thread.sleep(2000);
        bool = false;
        System.out.println("main - 结束");
    }

    public static class Thread0 implements Runnable{

        @Override
        public void run() {
            while (bool){
            }

            System.out.println("Thread2 - 结束");
        }
    }
}
