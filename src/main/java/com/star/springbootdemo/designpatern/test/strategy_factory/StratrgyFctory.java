package com.star.springbootdemo.designpatern.test.strategy_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: StarC
 * @Date: 2020/4/14 11:14
 * @Description:
 */
public class StratrgyFctory {

    private static StratrgyFctory stratrgyFctory ;
    private static Map<Integer,Strategy> strategyMap ;

    private StratrgyFctory(){}

    static{
        strategyMap = new HashMap<>(20);
        strategyMap.put(StrategyEnum.COUPON.getType(),new Coupon());
        strategyMap.put(StrategyEnum.MEMBER.getType(),new Member());

    }

    public static Strategy getStrategy(Integer type){

        return  strategyMap.get(type);
    }

    public static StratrgyFctory getStratrgyFctory() {
        if(stratrgyFctory == null){
            synchronized (StratrgyFctory.class){
                if(stratrgyFctory == null){
                    stratrgyFctory = new StratrgyFctory();
                }
            }
        }
        return stratrgyFctory;
    }
}
