package com.star.springbootdemo.Thread;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: StarC
 * @Date: 2019/9/2 14:04
 * @Description:
 */
public class MutilForkJoinPool {

    static int[] nums = new int[1000000];
    static  final int MAX_NUMS = 50000;
    static Random random = new Random();
    private LinkedList linkedList = new LinkedList();
    static{
        for(int i =0; i<nums.length; i++){
            nums[i]=random.nextInt(100);
            System.out.println(Arrays.stream(nums));
        }
    }
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        AddTask task = new AddTask(0,nums.length);
        forkJoinPool.execute(task);
        long sum = task.join();
        System.out.println(sum);
    }
    static class AddTask extends RecursiveTask<Long> {

        private int startIndex;
        private int endIndex;

        public AddTask(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }


        @Override
        protected Long compute() {

            if(endIndex-startIndex <= MAX_NUMS){
                long result = 0L;
                for(int i=0; i<nums.length;i++){
                    result += nums[i];
                }
                return result;
            }

            int middle = startIndex+(endIndex-startIndex)/2;
            AddTask addTask1 = new AddTask(startIndex, middle);
            AddTask addTask2 = new AddTask(middle, endIndex);

            addTask1.fork();
            addTask2.fork();
            return addTask1.join()+addTask2.join();
        }
    }


}
