package com.star.dynamicproxy;

import java.lang.reflect.Method;

/**
 * @Author: StarC
 * @Date: 2020/8/26 11:14
 * @Description:
 */
public interface Interceptor {
    public boolean before(Object object, Object target, Method method,Object[] args);
    public void around(Object object, Object target, Method method,Object[] args);
    public void after(Object object, Object target, Method method,Object[] args);
}
