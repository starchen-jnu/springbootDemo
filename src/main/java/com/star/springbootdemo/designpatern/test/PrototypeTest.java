package com.star.springbootdemo.designpatern.test;

import java.util.Observer;

/**
 * @Author: StarC
 * @Date: 2020/4/13 11:38
 * @Description:
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Subject subject = new Subject("star");
        Student student = new Student(subject,"chen");
        System.out.println("before:"+student);
        Student copyStudent = (Student) student.clone();
        copyStudent.setSubject(new Subject("wang"));
        System.out.println("copy:"+copyStudent);
        System.out.println("now:"+student);



    }
}
