package com.jfp.datamiddle.test.aqstest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/26 21:31
 * @update 2020/12/26 21:31
 **/
public class CyclicBarrierTest {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args){
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
        new Thread(new MThread()).start();
    }

    public static class MThread implements Runnable{

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "await 结束");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
