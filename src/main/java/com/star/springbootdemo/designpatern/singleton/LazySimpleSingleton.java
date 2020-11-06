package com.star.springbootdemo.designpatern.singleton;

import java.util.Vector;

/**
 * @Author: StarC
 * @Date: 2019/10/26 9:43
 * @Description:
 */
public class LazySimpleSingleton {

    private LazySimpleSingleton() {
    }

    private static LazySimpleSingleton lazy = null;

    public static  LazySimpleSingleton getInstance() {
        if (lazy == null) {
            synchronized (LazySimpleSingleton.class){
                if(lazy == null){
                    lazy = new LazySimpleSingleton();
                }
            }
        }
        return lazy;
    }

    static class ExectorThread implements Runnable {

        @Override
        public  void run() {
            LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + lazySimpleSingleton);
        }
    }

    public static void main(String[] args) {

        new Thread(new ExectorThread()).start();
        new Thread(new ExectorThread()).start();


        System.out.println("end");
    }
}
