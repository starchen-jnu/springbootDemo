package com.star.springbootdemo.designpatern.test;

/**
 * @Author: StarC
 * @Date: 2020/4/13 9:55
 * @Description:
 */
public class Singleton {

    private Singleton(){}

    private static volatile Singleton instance;

    public static synchronized Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
