package com.star.springbootdemo.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: StarC
 * @Date: 2019/8/30 16:08
 * @Description:
 */
public class ParallelComputing  {
    private static final int COUNT = 4;
    private static final int SUM = 20000;
    public void getResult() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        MyTask t1 = new MyTask(1, 80000); //1-5 5-10 10-15 15-20
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);
        Future<List<Integer>> f1 = executorService.submit(t1);
        Future<List<Integer>> f2 = executorService.submit(t2);
        Future<List<Integer>> f3 = executorService.submit(t3);
        Future<List<Integer>> f4 = executorService.submit(t4);

        f1.get();
        f2.get();
        f3.get();
        f4.get();

        executorService.shutdown();
    }



    static class MyTask implements Callable<List<Integer>>{
        private int start;
        private int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public List<Integer>getNumList(int start, int end){
            List<Integer>results = null;
            for(int i = start; i<=end;i++){
               if(isPrime(i)) {
                    results.add(i);
                }
            }

            return results;

        }
        public boolean isPrime(Integer num){
            for(int i=2; i<=num/2; i++) {
                if(num % i == 0) return false;
            }
            return true;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer>results = getNumList(start,end);
            return results;
        }
    }
}
