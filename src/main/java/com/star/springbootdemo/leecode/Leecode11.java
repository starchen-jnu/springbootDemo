package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/30 15:39
 * @Description:
 */
public class Leecode11 {

    public static void main(String[] args) {
        new Leecode11().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

    public int maxArea(int[] height) {

        int L = height.length;
        int p = 0;
        int q = L-1;
        int result = Integer.MIN_VALUE;
        while(p<L-1){
            while(p<q){
                int left = q-p;
                result = Math.max(result,left*(Math.min(height[p],height[q])));
                q--;
            }
            q = L-1;
            p++;
        }
        System.out.println(result);
        return result;
    }
}
