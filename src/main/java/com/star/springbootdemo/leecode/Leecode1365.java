package com.star.springbootdemo.leecode;

import java.util.Arrays;

/**
 * @Author: StarC
 * @Date: 2020/5/6 13:55
 * @Description:统计数组中小于每个值得个数；
 */
public class Leecode1365 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Leecode1365().smallerNumbersThanCurrent(new int[]{8,1,2,2,3})));
    }



    public int[] smallerNumbersThanCurrent(int[] nums) {

        int length = nums.length;
        int[] counts = new int[length];
        for(int i =0;i<length;i++){
            int count = 0;
            for(int j=0;j<length;j++){
                if(nums[j]<nums[i]){
                    count++;
                }
            }
            counts[i]=count;
        }

        return counts;
    }
}
