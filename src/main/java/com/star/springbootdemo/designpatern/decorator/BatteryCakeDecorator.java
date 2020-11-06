package com.star.springbootdemo.designpatern.decorator;

/**
 * @Author: StarC
 * @Date: 2019/10/27 15:15
 * @Description:
 */
public abstract  class BatteryCakeDecorator extends BatterCake {

    private BatterCake batterCake;

    public BatteryCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    public abstract void doing();

    @Override
    protected String getMsg() {
        return this.batterCake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.batterCake.getPrice();
    }
}
