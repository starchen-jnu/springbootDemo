package com.star.springbootdemo.designpatern.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: StarC
 * @Date: 2019/10/26 13:50
 * @Description:
 */
public class JDKMeipo implements InvocationHandler {

    private Object target;
    public  Object getInstance(Object target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);
        after();
        return obj;
    }
    public void before(){
        System.out.println("运行before");
    }
    public void after(){
        System.out.println("运行after");
    }

    interface Person{
        void findLove();
    }
    static class Customer implements Person{

        @Override
        public void findLove() {
            System.out.println("学富五车");
        }
    }

    public static void main(String[] args) {
        try {
            Person person = (Person) new JDKMeipo().getInstance(new Customer());
            person.findLove();
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream fos = new FileOutputStream("D://$Proxy0.class");
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
