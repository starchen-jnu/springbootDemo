package com.star.springbootdemo.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: StarC
 * @Date: 2019/8/30 15:25
 * @Description:
 */
public class CycliBarrierDemo {

    public void run(){
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Let's go");
            }
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<3;i++){
            int user = i+1;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep((long) Math.random()*10000);
                    System.out.println(user+"到达聚餐，当前已有"+(cyclicBarrier.getNumberWaiting()+1));
                    try {
                        cyclicBarrier.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("拍照完成，准备吃饭");
                    Thread.sleep((long) Math.random()*10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        executorService.execute(runnable);
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        CycliBarrierDemo cycliBarrierDemo = new CycliBarrierDemo();
        cycliBarrierDemo.run();
    }
}
