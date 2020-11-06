package com.star.springbootdemo.algorithm.leecode;

import java.util.Arrays;

/**
 * @Author: StarC
 * @Date: 2020/3/23 10:27
 * @Description:牢房问题
 */
public class Leetcode957 {

    public static void main(String[] args) {

        int n = 7;
        int[] arr = new int[]{0,1,0,1,1,0,0,1};
        int[] target = Arrays.copyOf(arr,arr.length);
        for(int i = 0;i< n+1;i++){
            if(i!=0){
                target = adjustArr(target);
            }
            System.out.println(i+"天:"+Arrays.toString(target));
        }
    }

    private static int[] adjustArr(int[] arr){
        int length = arr.length;
        int[] target = Arrays.copyOf(arr,arr.length);
        for(int i =1;i<length-1; i++){
            if(arr[i-1] == arr[i+1]){
                target[0]=0;
                target[7]=0;
                target[i]=1;
            }else{
                target[i]=0;
            }
        }
        return target;
    }
}
