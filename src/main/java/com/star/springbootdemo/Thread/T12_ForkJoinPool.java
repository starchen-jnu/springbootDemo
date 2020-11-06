package com.star.springbootdemo.Thread;

/**
 * @Author: StarC
 * @Date: 2019/9/9 20:49
 * @Description:
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
public class T12_ForkJoinPool {
    static int[] nums = new int[7000000];
    static final int MAX_NUM = 50000;
    static Random r = new Random();
    static {
        for(int i=0; i<nums.length; i++) {
            nums[i] = r.nextInt(100);
        }
        long t1 = System.currentTimeMillis();
        System.out.println(Arrays.stream(nums).sum()); //stream api
        long t2 = System.currentTimeMillis();
        long t3 = t2-t1;
        System.out.println("T1时间："+t3);
    }
    /*示例一：没有返回值
    static class AddTask extends RecursiveAction {
        int start, end;
        AddTask(int s, int e) {
            start = s;
            end = e;
        }
        @Override
        protected void compute() {
            if(end-start <= MAX_NUM) {
                long sum = 0L;
                for(int i=start; i<end; i++) sum += nums[i];
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            } else {
                int middle = start + (end-start)/2;
                AddTask subTask1 = new AddTask(start, middle);
                AddTask subTask2 = new AddTask(middle, end);
                subTask1.fork();
                subTask2.fork();
            }
        }
    }
    */
    //示例二：有返回值
    static class AddTask extends RecursiveTask<Long> {
        private static final long serialVersionUID = 1L;
        int start, end;
        AddTask(int s, int e) {
            start = s;
            end = e;
        }
        @Override
        protected Long compute() {
            if(end-start <= MAX_NUM) {
                long sum = 0L;
                for(int i=start; i<end; i++) sum += nums[i];
                return sum;
            }
            int middle = start + (end-start)/2;
            AddTask subTask1 = new AddTask(start, middle);
            AddTask subTask2 = new AddTask(middle, end);
            subTask1.fork();
            subTask2.fork();
            return subTask1.join() + subTask2.join();
        }
    }
    public static void main(String[] args) throws IOException {
        ForkJoinPool fjp = new ForkJoinPool();
        long t1 = System.currentTimeMillis();
        AddTask task = new AddTask(0, nums.length);
        fjp.execute(task);
        long result = task.join();
        long t2 = System.currentTimeMillis();
        long t3 = t2-t1;
        System.out.println("t2:"+ t3);
        System.out.println(result);
        //阻塞，执行完
        //System.in.read();
    }
}
