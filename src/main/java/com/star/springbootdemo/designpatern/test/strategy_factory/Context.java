package com.star.springbootdemo.designpatern.test.strategy_factory;

/**
 * @Author: StarC
 * @Date: 2020/4/14 11:26
 * @Description:
 */
public class Context {

    private Strategy strategy;

    public double getResults(double sum, Integer type){
        strategy = StratrgyFctory.getStratrgyFctory().getStrategy(type);
        return strategy.CalResult(sum,type);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
