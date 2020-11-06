package com.star.springbootdemo.AOPproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: StarC
 * @Date: 2019/10/29 11:11
 * @Description:
 */
public class ProxyBean implements InvocationHandler {


    private Interceptor interceptor = null;
    private Object target = null;

    public static Object getProxyBean(Object obj, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.interceptor = interceptor;
        proxyBean.target = obj;
        Object object = Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),proxyBean);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Object retObj = null;
        try {
            Invocation invocation = new Invocation(target,method,args);

            if(this.interceptor.useAround()){
                retObj = this.interceptor.around(invocation);
            }else{
                retObj = method.invoke(args);
            }
        } catch (Exception e) {
            exceptionFlag = true;
        }

        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
            return retObj;
        }
        return null;
    }
}
