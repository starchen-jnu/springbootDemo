package com.star.springbootdemo.Thread;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: StarC
 * @Date: 2020/8/20 15:02
 * @Description:
 */
public class MyContain<T> {

    private LinkedList<T> linkedList = new LinkedList<>();
    private static final Integer MAX= 5;
    private static Integer count = 0;
    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public void put(T t){
        while(linkedList.size() == MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.add(t);
        count++;
        this.notifyAll();
    }

    public T get(){
        T t ;
        while(linkedList.size()<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = linkedList.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public void produce(T t){

        try {
            lock.lock();
            while(linkedList.size() == MAX){
                    producer.await();
            }
            linkedList.add(t);
            count++;
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public T consume(){
        T t = null ;
        try {
            lock.lock();
            while(linkedList.size()<=0){
                consumer.await();
            }
            t = linkedList.removeFirst();
            count++;
            producer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }

    List<String> strs = new ArrayList<>();
    List<String> strsSync = Collections.synchronizedList(strs);

    public void testThrea(){

        Future<Integer> future = Executors.newFixedThreadPool(3).submit(()->{
            return 3;
        });

    }


}
