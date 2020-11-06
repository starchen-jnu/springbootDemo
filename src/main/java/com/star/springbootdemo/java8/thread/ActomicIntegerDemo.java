package com.star.springbootdemo.java8.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: StarC
 * @Date: 2020/4/7 15:51
 * @Description:
 */
public class ActomicIntegerDemo {


    private static final int THREAD_COUNT = 2;
    private static  AtomicInteger atomicInteger = new AtomicInteger(0);
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);



    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Thread1(),"threa1").start();
//        new Thread(new Thread1(),"threa2").start();
//        new Thread(new Thread1(),"threa3").start();
        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i = 0;i < threads.length; i++){
            threads[i] = new Thread(()->{
                for(int j=0;j<1000;j++){
                    atomicInteger.incrementAndGet();
                }
                countDownLatch.countDown();
            },"线程"+i);
            threads[i].start();
        }

        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }

    static class Shared{
        static  AtomicInteger integer  = new AtomicInteger(0);
    }

    static class Thread1 implements Runnable{

        int i = 0;

        @Override
        public void run() {

//            for(int i = 0; i < 3; i++ ){
//                int andSet = Shared.integer.getAndSet(i);
//                System.out.println(Thread.currentThread().getName()+":"+andSet);
//            }
           while(Shared.integer.incrementAndGet() <10){
               System.out.println(Thread.currentThread().getName()+":"+Shared.integer.get());
           }

        }
    }
}
