package com.star.springbootdemo.designpatern.test;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: StarC
 * @Date: 2020/4/13 11:34
 * @Description:
 */
@Data
@NoArgsConstructor
public class Student implements Cloneable {

    private Subject subject;
    private String name;

    public Student(String name){
        this.name = name;
    }

    public Student(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Student student = (Student) super.clone();
            student.subject = (Subject) subject.clone();
            return student;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}
