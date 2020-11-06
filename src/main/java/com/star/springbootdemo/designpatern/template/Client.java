package com.star.springbootdemo.designpatern.template;

/**
 * @Author: StarC
 * @Date: 2019/10/27 13:49
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        NetWorkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();
    }
}
