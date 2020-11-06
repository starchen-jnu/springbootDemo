package com.star.springbootdemo.designpatern.observer;

/**
 * @Author: StarC
 * @Date: 2019/9/2 13:37
 * @Description:
 */
public interface Subject {

    public void register(Observer observer);
    public void remove(Observer observer);
    public void notifys();
}
