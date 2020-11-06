package com.star.springbootdemo.designpatern.strategy;

/**
 * @Author: StarC
 * @Date: 2019/10/27 10:39
 * @Description:
 */
public class CashbackStrategy implements PromotionStrage {
    @Override
    public void doPromotion() {
        System.out.println("cashback");
    }
}
