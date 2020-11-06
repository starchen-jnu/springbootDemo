package com.star.springbootdemo.leecode;

import java.sql.ResultSet;

/**
 * @Author: StarC
 * @Date: 2020/4/15 15:59
 * @Description:
 */
public class Leecode258 {

    public static void main(String[] args) {
        addDigits(38);
    }

    public static int addDigits(int num) {

        int target = num;

        while(target >= 10){
            target = getTarget(target);
        }

        System.out.println(target);
        return target;

    }

    private static int getTarget(int num){
        int res = 0;
        while(num != 0) {
            res += num % 10;
            num /= 10;

        }
        return res;
    }

}
