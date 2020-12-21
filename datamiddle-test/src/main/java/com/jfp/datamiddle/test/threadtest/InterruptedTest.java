package com.jfp.datamiddle.test.threadtest;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/21 21:23
 * @update 2020/12/21 21:23
 **/
public class InterruptedTest {

    public static void main(String[] args){
        Thread thread = new Thread(new MyThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println("结束");

        try {
            thread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.notify();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("错误");
                e.printStackTrace();
            }
        }
    }


}
