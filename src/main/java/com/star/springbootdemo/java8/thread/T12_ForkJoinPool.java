package com.star.springbootdemo.java8.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: StarC
 * @Date: 2020/4/7 9:22
 * @Description:
 */
public class T12_ForkJoinPool {

    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();
    static {

        Long beginTime = System.currentTimeMillis();
        for(int i=0; i<nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        Long endTime = System.currentTimeMillis();
        String time = endTime-beginTime+"";
        System.out.println("方法1："+Arrays.stream(nums).sum()+"花费时间："+time+"ms"); //stream api
    }
    public static void main(String[] args) {

        AtomicInteger integer = new AtomicInteger(0);
        for(int i = 0; i < 10; i++ ){
            int andSet = integer.getAndSet(i);
        }

        Long beginTime = System.currentTimeMillis();
       ForkJoinPool fjp = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        //fjp.execute(task);
        //long result = task.join();
        long result = fjp.invoke(task);

        Long endTime = System.currentTimeMillis();
        String time = endTime-beginTime+"";

        System.out.println("方法1："+result+"花费时间："+time+"ms");


    }

    static class AddTask extends RecursiveTask<Long>{

        private static final long serialVersionUID = 1L;
        int start, end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {

            if(end - start <= MAX_NUM){
                long sum = 0L;
                for(int i = start;i< end; i++){
                    sum += nums[i];
                }
                return sum;

            }

            int middle = (start+end)/2;
            AddTask addTask1 = new AddTask(start,middle);
            AddTask addTask2 = new AddTask(middle,end);
//            addTask1.fork();
//            addTask2.fork();
            invokeAll(addTask1,addTask2);

            return addTask1.join()+addTask2.join();
        }
    }

}
