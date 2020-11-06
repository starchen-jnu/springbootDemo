package com.star.springbootdemo.designpatern.proxy;

/**
 * @Author: StarC
 * @Date: 2019/8/26 10:56
 * @Description:
 */
public class Client {
    public static void main(String[] args) {

        ObjectI target = new ObjectInstance();
        ObjectI objectI = (ObjectI) new ProxyFactory(target).getProxyInstance();
        objectI.getName();
    }
}
