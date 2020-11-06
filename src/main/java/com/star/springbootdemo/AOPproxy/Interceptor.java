package com.star.springbootdemo.AOPproxy;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: StarC
 * @Date: 2019/10/29 11:00
 * @Description:
 */
public interface Interceptor {

    public boolean before();
    public void after();
    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;
    public void afterReturning();
    public void afterThrowing();
    boolean useAround();

}
