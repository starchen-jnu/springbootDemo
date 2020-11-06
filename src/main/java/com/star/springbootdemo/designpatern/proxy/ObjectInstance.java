package com.star.springbootdemo.designpatern.proxy;

/**
 * @Author: StarC
 * @Date: 2019/8/26 10:56
 * @Description:
 */
public class ObjectInstance implements ObjectI {
    @Override
    public void getName() {
        System.out.println(this.getClass());
    }
}
