package com.star.springbootdemo.Thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: StarC
 * @Date: 2019/8/30 14:23
 * @Description: Conditonn 锁
 */
public class ConditonAndLock<T> {

    private final  LinkedList<T> linkList = new LinkedList<>();
    private final static int max = 5;
    private int count = 0;

    private static Lock lock = new ReentrantLock();
    private Condition producer= lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try {
            lock.lock();
            while(linkList.size()== max){
                producer.await();
            }
            linkList.add(t);
            count++;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {
            lock.lock();
            while (linkList.size()==0){
                consumer.await();
            }
            t = linkList.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        ConditonAndLock<Integer>conditonAndLock = new ConditonAndLock<>();
        for(int i =0;i<10;i++){
            new Thread(()->{
                for(int j=0; j<5; j++)
                System.out.println(conditonAndLock.get());
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<2;i++){
            new Thread(()->{
                for(int j=0;j<25;j++){
                    conditonAndLock.put(j);
                }
            }).start();
        }
    }


}
