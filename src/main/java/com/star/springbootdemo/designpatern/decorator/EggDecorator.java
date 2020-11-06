package com.star.springbootdemo.designpatern.decorator;

/**
 * @Author: StarC
 * @Date: 2019/10/27 15:17
 * @Description:
 */
public class EggDecorator extends BatteryCakeDecorator {


    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    public void doing() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+5;
    }
}
