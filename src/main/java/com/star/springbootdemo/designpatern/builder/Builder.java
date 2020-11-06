package com.star.springbootdemo.designpatern.builder;

/**
 * @Author: StarC
 * @Date: 2019/8/26 13:31
 * @Description:
 */
public abstract class Builder {
    public House house = new House();
    public abstract  void  buildBasic();
    public abstract  void  buildWals();
    public abstract  void  roofed();

    public House buildHouse(){
        return  house;
    }

}
