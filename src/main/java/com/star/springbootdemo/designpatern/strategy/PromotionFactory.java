package com.star.springbootdemo.designpatern.strategy;

import java.util.HashMap;

/**
 * @Author: StarC
 * @Date: 2019/10/27 10:36
 * @Description:
 */
public class PromotionFactory {

    static HashMap<String,PromotionStrage> promotionStrageHashMap = new HashMap<>();
    static{
        promotionStrageHashMap.put(PromotionKey.COUPON.name(),new CouponStrategy());
        promotionStrageHashMap.put(PromotionKey.CASHBACK.name(),new CashbackStrategy());
    }
    public PromotionFactory(){};

    public PromotionStrage promotionStrage(String promotionKey){
        return promotionStrageHashMap.get(promotionKey);
    }


}
