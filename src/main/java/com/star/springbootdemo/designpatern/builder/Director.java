package com.star.springbootdemo.designpatern.builder;

/**
 * @Author: StarC
 * @Date: 2019/8/26 13:35
 * @Description:
 */
public class Director {
    private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
    public House constructHouse(){
        builder.roofed();
        builder.buildBasic();
        builder.buildWals();
        return builder.buildHouse();
    }
}
