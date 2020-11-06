package com.star.springbootdemo.AOPproxy;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: StarC
 * @Date: 2019/10/29 11:04
 * @Description:
 */
public class Myinterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("... before ...");
        return true;
    }

    @Override
    public void after() {

        System.out.println("... after ...");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("... before ...");
        Object object = invocation.procceed();
        System.out.println("... after ...");
        return object;
    }

    @Override
    public void afterReturning() {
        System.out.println("... afterReturning ...");
    }

    @Override
    public void afterThrowing() {

        System.out.println("... afterThrowing ...");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
