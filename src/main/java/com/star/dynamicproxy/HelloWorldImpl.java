package com.star.dynamicproxy;

/**
 * @Author: StarC
 * @Date: 2020/8/26 11:26
 * @Description:
 */
public class HelloWorldImpl implements HelloWorldI {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}
