package com.star.springbootdemo.designpatern.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: StarC
 * @Date: 2020/4/12 15:10
 * @Description:
 */
public class ProxyFactory  {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理开始");
                Object invoke = method.invoke(target, args);
                System.out.println("代理后");
                return invoke;
            }
        });
    }

}
