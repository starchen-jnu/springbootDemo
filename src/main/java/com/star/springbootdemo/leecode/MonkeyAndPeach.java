package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/5/15 9:13
 * @Description:
 */
public class MonkeyAndPeach {
    public static void main(String[] args) {
        getResult(10);
        getResult(9);
        getResult(1);
    }

    public static int getResult(int n){

        if(n > 10 || n < 0 ){
            return Integer.MIN_VALUE;
        }
        int[] p = new int[11];
        p[0] = 0;
        p[10] = 1;
        for(int i=9;i>0;i--){
            p[i] = 2* p[i+1]+2;
        }
        System.out.println(p[n]);
        return p[n];
    }
}
