package com.star.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author StarC
 * @Date 2020/10/16 15:57
 * @Description:
 */
public class JdkProxy implements InvocationHandler {

    private Object target;
    public Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(this.target,args);
        after();
        return object;
    }
    private void before(){

        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }

}
