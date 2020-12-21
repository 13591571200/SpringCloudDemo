package com.jfp.datamiddle.test.threadtest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/21 22:04
 * @update 2020/12/21 22:04
 **/
public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
    }
}
