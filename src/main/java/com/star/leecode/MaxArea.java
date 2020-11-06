package com.star.leecode;

/**
 * @Author StarC
 * @Date 2020/10/13 19:36
 * @Description:
 */
public class MaxArea {

    public int maxArea(int[] height) {

        int max_area = 0;
        int len = height.length;
        for(int i=0;i<len-1;i++){
            for(int j =i+1;j<len;j++){
                int y = Math.min(height[i],height[j]);
                int x = j-i;
                int area = y *x;
                max_area =  Math.min(max_area,area);
            }
        }

        return max_area;

    }


    public int maxArea1(int[] height) {

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
