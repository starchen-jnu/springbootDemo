package com.star.springbootdemo.algorithm.leecode;

/**
 * @Author: StarC
 * @Date: 2020/3/31 21:27
 * @Description:动态规划求最大子序列
 */
public class MaxSum {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,-4,3,-2,-1};
        System.out.println(getMaxNum(arr));
    }
    public static int getMaxNum(int[] arr){
        int ans = arr[0];
        int sum =0;
        for(int i : arr){
            if(sum > 0){
                sum += i;
            }else{
                sum = i;
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
