package com.star.springbootdemo.designpatern.test;

import java.math.BigDecimal;

/**
 * @Author: StarC
 * @Date: 2020/8/11 15:30
 * @Description:
 */
public class CEOHandler implements Handler {
    @Override
    public Boolean process(Process process) {
        if(process.getType() == 1){
            System.out.println("CEO");
        }
        return null;
    }
}
