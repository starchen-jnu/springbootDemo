package com.star.springbootdemo.designpatern.test;

/**
 * @Author: StarC
 * @Date: 2020/4/12 15:16
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        IteacherDao iteacherDao = new TeacherImpl();
        IteacherDao instance = (IteacherDao) new ProxyFactory(iteacherDao).getProxyInstance();
        instance.sayHello();
    }
}
