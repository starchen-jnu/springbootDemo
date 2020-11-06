package com.star.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @Author: StarC
 * @Date: 2020/8/26 11:15
 * @Description:
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object object, Object target, Method method, Object[] args) {
        System.out.println("------before--------");
        return true;
    }

    @Override
    public void around(Object object, Object target, Method method, Object[] args) {
        System.out.println("--------around--------");

    }

    @Override
    public void after(Object object, Object target, Method method, Object[] args) {
        System.out.println("---------after---------");

    }
}
