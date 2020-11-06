package com.star.springbootdemo.designpatern.test.strategy_factory;

/**
 * @Author: StarC
 * @Date: 2020/4/14 11:20
 * @Description:
 */
public enum StrategyEnum {
    COUPON(1,"优惠价"),
    MEMBER(2,"会员价");

    private Integer type;
    private String describe;

    StrategyEnum(Integer type, String describe) {
        this.type = type;
        this.describe = describe;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }}
