package com.star.jvm;

/**
 * @Author: StarC
 * @Date: 2020/8/18 13:46
 * @Description:
 */
public class TestThreadLocal {

    private static  ThreadLocal<Integer> threadLocal = new ThreadLocal<>();



    public static void main(String[] args) {

        new Thread(()->{
            threadLocal.set(1);
            System.out.println(threadLocal.get());

        }).start();

    }
}
