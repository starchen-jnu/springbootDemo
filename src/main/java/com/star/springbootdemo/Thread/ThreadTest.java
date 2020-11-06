package com.star.springbootdemo.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * @Author: StarC
 * @Date: 2020/8/17 14:01
 * @Description:
 */
public class ThreadTest {

    public static void main(String[] args) {

        System.out.println(test());

    }

    public static Integer test(){
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(() -> {
                try {
                    Thread.sleep(100000);
                    System.out.println(Thread.currentThread().getName() + "Thread start");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println(Thread.currentThread().getName()+"Thread start");
            executorService.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
