package com.star.springbootdemo.ThreadControl;

/**
 * @Author: StarC
 * @Date: 2019/10/28 16:00
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        new Thread(()->{
            User user = new User("1001","star");
            System.out.println(Thread.currentThread().getName()+":"+UserContextHolder.currentUser());
            UserContextHolder.set(user);
            System.out.println(Thread.currentThread().getName()+":"+UserContextHolder.currentUser());

        },"thread1").start();

        new Thread(()->{
            User user = new User("1002","chen");
            UserContextHolder.set(user);
            System.out.println(Thread.currentThread().getName()+":"+UserContextHolder.currentUser());
        },"thread2").start();
        System.out.println("---end-----");
    }


}
