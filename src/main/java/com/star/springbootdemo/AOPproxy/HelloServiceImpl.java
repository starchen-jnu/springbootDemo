package com.star.springbootdemo.AOPproxy;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: StarC
 * @Date: 2019/10/29 10:58
 * @Description:
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(StringUtils.isEmpty(name)){
            throw new RuntimeException("params is null");
        }
        System.out.println("hello" + name);
    }
}
