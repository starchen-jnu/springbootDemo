package com.star.springbootdemo.designpatern.decorator;

/**
 * @Author: StarC
 * @Date: 2019/10/27 15:21
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        BatterCake batterCake;
        batterCake = new BaseBatterCake();
        batterCake = new EggDecorator(batterCake);
        batterCake = new EggDecorator(batterCake);
        System.out.println(batterCake.getMsg());
    }
}
