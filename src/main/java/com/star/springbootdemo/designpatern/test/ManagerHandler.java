package com.star.springbootdemo.designpatern.test;

import java.math.BigDecimal;

/**
 * @Author: StarC
 * @Date: 2020/8/11 15:27
 * @Description:
 */
public class ManagerHandler implements Handler {
    @Override
    public Boolean process(Process process) {
        if(process.getType() == 0){
            System.out.println("manage");
        }
        return null;
    }
}
