package com.star.springbootdemo.java8.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author: StarC
 * @Date: 2020/4/8 9:28
 * @Description:
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new BarrierExecutor());
        new Thread1("a",cyclicBarrier);
        new Thread1("b",cyclicBarrier);

    }
}
