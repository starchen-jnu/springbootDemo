package com.star.springbootdemo.Thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: StarC
 * @Date: 2020/8/20 19:32
 * @Description:
 */
public class ForkJoinPoolTest {

    static int[] nums = new int[1000000];
    static final int MAX_NUM = 50000;
    static Random random = new Random();
    static {
        for(int i=0;i<nums.length;i++){
            nums[i] = random.nextInt(100);
        }
    }

    static void calculateTime(){
        long start = System.currentTimeMillis();
        long result = Arrays.stream(nums).sum();
        long end = System.currentTimeMillis();
        System.out.println("TimeLeft:"+(end-start));
        System.out.println("target:"+result);
    }


    static class AddTask extends RecursiveTask<Long>{

        int start,end;

        public AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if(end-start<=MAX_NUM){
                long sum=0;
                for(int i = start;i<end;i++){
                    sum +=nums[i];
                }
                return sum;
            }
            int middle = start+(end-start)/2;
           AddTask addTask = new AddTask(start,middle);
           AddTask addTask1 = new AddTask(middle,end);
            addTask.fork();
            addTask1.fork();
            return addTask.join()+addTask1.join();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ForkJoinPool fjp = new ForkJoinPool();
        AddTask addTask = new AddTask(0,nums.length);
        fjp.execute(addTask);
        long result = addTask.join();
        long endTime = System.currentTimeMillis();
        System.out.println("timeremain:"+(endTime-startTime));
        System.out.println(result);

        System.out.println("=======================================================");
        calculateTime();
    }
}
