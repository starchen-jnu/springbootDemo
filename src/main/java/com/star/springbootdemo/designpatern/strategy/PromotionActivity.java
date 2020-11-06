package com.star.springbootdemo.designpatern.strategy;

/**
 * @Author: StarC
 * @Date: 2019/10/27 10:47
 * @Description:
 */
public class PromotionActivity {

    PromotionStrage promotionStrage;

    public PromotionActivity(PromotionStrage promotionStrage) {
        this.promotionStrage = promotionStrage;
    }

    public void execute(){
        promotionStrage.doPromotion();
    }

}
