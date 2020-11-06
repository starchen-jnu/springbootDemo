package com.star.springbootdemo.test;

/**
 * @Author: StarC
 * @Date: 2019/11/13 15:50
 * @Description:
 */
public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return super.findClass(name);
    }


}
