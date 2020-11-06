package com.star.leecode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author StarC
 * @Date 2020/10/13 14:34
 * @Description:多线程按顺序执行
 */
public class ThreadTest {

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

   /* volatile boolean isThread1 = false;
    volatile boolean isThread2 = false;*/


    private void execute() {
        System.out.println("-------线程-----");
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            System.out.println("线程按顺序执行");
            //isThread1 = true;
            condition1.signal();
            lock.unlock();
        }).start();

        new Thread(() -> {

            lock.lock();

            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread1运行");
            //isThread2 = true;
            condition2.signal();
            lock.unlock();
        }).start();


        new Thread(() -> {
            lock.lock();
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2运行");
            lock.unlock();
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        //使用可重用锁+条件锁的方法
       /* new ThreadTest().execute();
        //单例线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(()->{
            System.out.println("thread1运行...");
        });
        service.submit(()->{
            System.out.println("thread2运行...");
        });*/
        //使用join方法
        Thread thread1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("join:thread1运行...");
        });
        Thread thread2 = new Thread(()->{System.out.println("join:thread2运行...");});
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        set.add(1);
        set.add(26);
        set.add(3);

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        //Collections.reverse(list);
        System.out.println(list);

        //AbstractQueuedSynchronizer
    }

}
