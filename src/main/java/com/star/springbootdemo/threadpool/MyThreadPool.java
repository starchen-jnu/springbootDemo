package com.star.springbootdemo.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: StarC
 * @Date: 2019/9/16 20:05
 * @Description:手写线程池
 */
public class MyThreadPool {
    private  BlockingQueue<Runnable> workQueue;
    private int corepoolsize;
    private List<WorkThread>threadList = new ArrayList<>();

    public MyThreadPool(BlockingQueue<Runnable> workQueue, int corepoolsize) {
        this.workQueue = workQueue;
        this.corepoolsize = corepoolsize;
        for(int i = 0; i<corepoolsize;i++){
            WorkThread workThread = new WorkThread();
            workThread.start();
            //threadList.add(workThread);

        }
    }
    public void execute(Runnable command){
        try {
            workQueue.put(command);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while(true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
