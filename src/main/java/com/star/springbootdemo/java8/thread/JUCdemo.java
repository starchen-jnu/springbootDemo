package com.star.springbootdemo.java8.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: StarC
 * @Date: 2020/4/8 9:34
 * @Description:
 */
public class JUCdemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static CountDownLatch latch = new CountDownLatch(2);
    private static CountDownLatch latchs = new CountDownLatch(3);
    private static final long awaitTime = 5 * 1000;
    public static void main(String[] args) throws InterruptedException {

       //testSemaphore();
        testPhaser();

    }


    public static void testPhaser() throws InterruptedException {
        Phaser phaser = new Phaser(1);
        int curPhase;
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for(int i=0;i<3;i++){
            executor.submit(new MyThread("线程"+i+"",phaser));
        }

//        new MyThread("A",phaser);
//        new MyThread("B",phaser);
//        new MyThread("C",phaser);

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("phase:"+curPhase+"complete");
        latchs.countDown();
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("phase:"+curPhase+"complete");
        latchs.countDown();
        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("phase:"+curPhase+"complete");
        latchs.countDown();

        latchs.await();
        executor.shutdownNow();
       /* try {
            executor.shutdown();
            if(!executor.awaitTermination(awaitTime, TimeUnit.MILLISECONDS)){
                // 超时的时候向线程池中所有的线程发出中断(interrupted)。
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
            System.out.println("awaitTermination interrupted: " + e);
            executor.shutdownNow();
        }*/
        phaser.arriveAndDeregister();

        if(phaser.isTerminated()){
            System.out.println("The Phaser is terminated");
        }
    }

    static class MyThread implements Runnable{

        private String name ;
        private Phaser phaser;

        public MyThread(String name, Phaser phaser) {
            this.name = name;
            this.phaser = phaser;
            phaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            System.out.println(name+":begin Phase one");
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name+":begin Phase two");
            phaser.arriveAndAwaitAdvance();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name+":begin Phase three");
            phaser.arriveAndDeregister();
        }
    }



    public static void testSemaphore(){
        Semaphore semaphore = new Semaphore(1);
        new IncreThread("A",semaphore);
        new DecrThread("B",semaphore);
    }

    public static void testShutExecutor() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(()->{

            return 1;
        });
         future.get();

        for(int i = 0; i< 2; i++){
            executor.execute(()->{
                try {
                    int a = atomicInteger.incrementAndGet();
                    int sum = 0;
                    Thread.sleep(500);
                    sum += a;
                    System.out.println(Thread.currentThread().getName()+":"+sum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

        }

        try {
            executor.shutdown();
            if(!executor.awaitTermination(awaitTime, TimeUnit.MILLISECONDS)){
                // 超时的时候向线程池中所有的线程发出中断(interrupted)。
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
            System.out.println("awaitTermination interrupted: " + e);
            executor.shutdownNow();
        }

        System.out.println("end");
    }

    static class Shared{
        public static int count = 0;
    }
    static class IncreThread implements Runnable{
        private String name;
        private Semaphore semaphore;

        public IncreThread(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println(name+"线程等待允许");
                semaphore.acquire();
                System.out.println(name+"线程获取允许");
                for(int i=0;i<6;i++){
                    Shared.count++;
                    System.out.println(name+":"+Shared.count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }

    static class DecrThread implements Runnable{
        private String name;
        private Semaphore semaphore;

        public DecrThread(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                System.out.println(name+"线程等待允许");
                semaphore.acquire();
                System.out.println(name+"线程获取允许");
                for(int i=0;i<6;i++){
                    Shared.count--;
                    System.out.println(name+":"+Shared.count);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
        }
    }
}
