package com.star.leecode;

import java.util.Arrays;

/**
 * @Author StarC
 * @Date 2020/10/29 19:43
 * @Description:
 */
public class Sort {

    public static void main(String[] args) {
        int[] nums={1,2,0,1,2,0,1,2,1};
         sort(nums);
    }

    public static void sort(int[] nums){
        int p0=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }

        int p1=p0;
        for(int j = p1;j<nums.length;j++){
            if(nums[j] == 1){
                int temp = nums[j];
                nums[j] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
