package com.star.springbootdemo.designpatern.test.strategy_factory;

/**
 * @Author: StarC
 * @Date: 2020/4/14 11:23
 * @Description:
 */
public class Member implements Strategy {
    @Override
    public double CalResult(double sum, Integer type) {

        return sum*0.9;
    }
}
