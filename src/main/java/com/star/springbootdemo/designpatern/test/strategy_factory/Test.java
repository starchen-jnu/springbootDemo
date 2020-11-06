package com.star.springbootdemo.designpatern.test.strategy_factory;

/**
 * @Author: StarC
 * @Date: 2020/4/14 11:41
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Context context =new Context();
        double sum = 1250;
        System.out.println(context.getResults(sum,2));
    }
}
