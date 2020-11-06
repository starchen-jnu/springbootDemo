package com.star.springbootdemo.designpatern.test;

import lombok.Data;

/**
 * @Author: StarC
 * @Date: 2020/4/13 11:32
 * @Description:
 */
@Data
public class Subject implements Cloneable{

    private String name ;

    public Subject(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Subject subject = (Subject) super.clone();
            return subject;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
