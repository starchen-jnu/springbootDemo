package com.star.springbootdemo.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/4/15 17:04
 * @Description:
 */
public class Leecode263 {
    public static void main(String[] args) {
        //isUgly(30);
        long begin = System.currentTimeMillis();
        nthUglyNumber(1690);
        long end = System.currentTimeMillis();
        String time = end -begin+"";
        System.out.println("Ö´ÐÐÊ±¼ä£º"+time);

    }

    public static int nthUglyNumber(int n) {

        int i =1;
        int times =0;
        while(times != n ){

            if(isUgly(i)) {
                times ++;
            }
            i++;

        }

        System.out.println(i-1);
        return i-1;
    }

    public static boolean isUgly(int num) {

        boolean flag = true;
        if(num <= 0){
            return false;
        }
        while(flag && num>1){
            if((num%2) ==0){
                num /= 2;
            }else if ((num%3) ==0){
                num /= 3;
            }else if ((num%5) ==0){
                num /= 5;
            }else{
                flag = false;
            }
        }
        //System.out.println(flag);
        return num==1?true:false;
    }
}
