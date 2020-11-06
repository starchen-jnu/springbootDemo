package com.star.springbootdemo.aop;

import com.star.springbootdemo.transaction.Extransaction;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: StarC
 * @Date: 2019/9/16 14:46
 * @Description:
 */
@Component
public class Man {

    @Extransaction
    public void study(String mark, int num, Date date){
        System.out.println("我正在学C++");
    }

    public void code(){
        System.out.println("我正在学习Java");
    }
}
