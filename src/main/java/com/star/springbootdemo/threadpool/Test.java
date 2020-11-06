package com.star.springbootdemo.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: StarC
 * @Date: 2019/9/16 20:33
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workList = new LinkedBlockingQueue<>(10);
        MyThreadPool myThreadPool = new MyThreadPool(workList,2);
        for(int i=0;i<10;i++){
            int num = i;
            myThreadPool.execute(()->{
                try {
                    Thread.sleep(5000);
                    System.out.println("线程:"+Thread.currentThread().getName()+"执行"+num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
