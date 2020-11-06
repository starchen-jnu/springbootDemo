package com.star.springbootdemo.designpatern.decorator;

/**
 * @Author: StarC
 * @Date: 2019/10/27 15:15
 * @Description:
 */
public class BaseBatterCake extends BatterCake {
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
