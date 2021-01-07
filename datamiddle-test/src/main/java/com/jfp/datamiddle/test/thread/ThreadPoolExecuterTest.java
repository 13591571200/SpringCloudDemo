package com.jfp.datamiddle.test.thread;

import java.time.LocalTime;
import java.util.concurrent.*;

public class ThreadPoolExecuterTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();
        ExecutorService executorService3 = Executors.newWorkStealingPool();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,60L, TimeUnit.SECONDS, new SynchronousQueue<>());
        threadPoolExecutor.execute(new MyThread());
        threadPoolExecutor.execute(new MyThread());
        threadPoolExecutor.execute(new MyThread());

    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.out.println("结束 " + LocalTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
