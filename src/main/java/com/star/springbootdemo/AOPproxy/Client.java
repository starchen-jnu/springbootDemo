package com.star.springbootdemo.AOPproxy;

/**
 * @Author: StarC
 * @Date: 2019/10/29 11:31
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService helloService1 = (HelloService) ProxyBean.getProxyBean(helloService, new Myinterceptor());
        helloService1.sayHello("star");
    }
}
