package com.star.springbootdemo.Thread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: StarC
 * @Date: 2019/8/30 16:47
 * @Description:
 */
public class ArrayBlockingDemo {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            try {
                blockingQueue.offer(i);
               /* if(i>=4){
                    System.out.println(blockingQueue.take());
                }*/
                System.out.println(blockingQueue.poll());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
