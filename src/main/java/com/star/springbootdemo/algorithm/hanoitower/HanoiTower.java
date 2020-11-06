package com.star.springbootdemo.algorithm.hanoitower;

import java.util.HashMap;

/**
 * @Author: StarC
 * @Date: 2020/3/10 22:06
 * @Description:
 */
public class HanoiTower {

    public static void main(String[] args) {
        HanoiTower.doTower(3,'A','B','C');
    }

    public static void doTower(int n,char from, char inter, char to){
        if(n ==1){
            System.out.println("盘子1从"+from+"塔座到"+to+"塔座");
        }else{
            doTower(n-1,from,to,inter);
            System.out.println("盘子"+n+",从"+from+"塔座到"+to+"塔座");
            doTower(n-1,inter,from,to);
        }

    }

}
