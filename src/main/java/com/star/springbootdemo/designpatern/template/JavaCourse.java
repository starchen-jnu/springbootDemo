package com.star.springbootdemo.designpatern.template;

/**
 * @Author: StarC
 * @Date: 2019/10/27 13:45
 * @Description:
 */
public class JavaCourse extends NetWorkCourse {
    @Override
    void checkHomeWork() {
        System.out.println("检查java作业");
    }
}
