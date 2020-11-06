package com.star.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @Author: StarC
 * @Date: 2019/8/25 10:31
 * @Description:   springboot+redis+mybatisplus+exceptionHandler+springbootConfigure
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.star.springbootdemo.mapper")
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
