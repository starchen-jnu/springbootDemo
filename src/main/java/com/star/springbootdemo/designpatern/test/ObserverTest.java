package com.star.springbootdemo.designpatern.test;

/**
 * @Author: StarC
 * @Date: 2020/4/13 15:04
 * @Description:
 */
public class ObserverTest {

    public static void main(String[] args) {
        Publish publish = new Publish();
        Subscribe subscribe = new Subscribe(publish);
        Subscribe1 subscribe1 = new Subscribe1(publish);
        publish.setData("begin");
    }
}
