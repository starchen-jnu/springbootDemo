package com.star.dynamicproxy;

/**
 * @Author: StarC
 * @Date: 2020/8/26 11:25
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        HelloWorldI helloWorldI = (HelloWorldI) InterceptorJdkProxy.getInstance(new HelloWorldImpl(),"com.star.dynamicproxy.MyInterceptor");
        helloWorldI.sayHello();
    }
}
