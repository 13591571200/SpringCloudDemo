package com.jfp.datamiddle.test.thread;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class PriorityBlockingQueueTest {

    public static void main(String[] args) {
        PriorityBlockingQueue<A> priorityBlockingQueue = new PriorityBlockingQueue();
        priorityBlockingQueue.add(new A(1));
        priorityBlockingQueue.add(new A(2));
        priorityBlockingQueue.add(new A(3));

        System.out.println(priorityBlockingQueue.poll().id);
        System.out.println(priorityBlockingQueue.poll().id);
        System.out.println(priorityBlockingQueue.poll().id);

    }

    private static class A implements Comparable{

        private Integer id;

        public A(Integer id) {
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {

            return ((A)o).id - id;
        }
    }
}
