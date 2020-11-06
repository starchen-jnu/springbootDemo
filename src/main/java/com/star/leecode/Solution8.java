package com.star.leecode;

import java.util.Arrays;

/**
 * @Author StarC
 * @Date 2020/10/12 20:55
 * @Description:
 */
public class Solution8 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int[] num = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,num,0,nums1.length);
        System.arraycopy(nums2,0,num,nums1.length,nums2.length);
        Arrays.sort(num);
        double d = 0L;
        if(num.length%2==0){
            d=(num[num.length/2]+num[num.length/2-1])/2.0;
        }else{
            d = num[num.length/2];

        }

        System.out.println(d);


    }
}
