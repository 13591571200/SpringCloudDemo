package com.jfp.datamiddle.test.threadtest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author jiafupeng
 * @desc
 * @create 2020/12/21 21:49
 * @update 2020/12/21 21:49
 **/
public class UnsafeTest {

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();
        long offset = unsafe.objectFieldOffset(Entry.class.getDeclaredField("id"));
        System.out.println("offset: " + offset);
        Entry entry = new Entry();
        entry.setId(1);
        boolean b = unsafe.compareAndSwapInt(entry, offset, 1, 2);
        System.out.println(b);
        System.out.println(entry.getId());
    }

    /**
     * 通过反射获取Unsafe实例
     */
    public static Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe)field.get(null);
    }

    public static class Entry{

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
