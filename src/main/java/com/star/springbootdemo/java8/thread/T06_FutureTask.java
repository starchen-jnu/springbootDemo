package com.star.springbootdemo.java8.thread;

import java.util.concurrent.*;


/**
 * @Author: StarC
 * @Date: 2020/4/7 9:58
 * @Description:
 */
public class T06_FutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            TimeUnit.SECONDS.sleep(1);
            return 1000;
        });
        new Thread(futureTask).start();
        System.out.println(future.get());
    }



}
