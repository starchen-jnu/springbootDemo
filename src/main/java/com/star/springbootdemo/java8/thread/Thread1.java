package com.star.springbootdemo.java8.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: StarC
 * @Date: 2020/4/8 9:24
 * @Description:
 */
public class Thread1 implements Runnable {


    private String name;
    private CyclicBarrier cyclicBarrier;

    public Thread1(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
        new Thread(this).start();
    }

    @Override
    public void run() {

        System.out.println(name+"start");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
