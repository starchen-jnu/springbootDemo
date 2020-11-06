package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/15 15:30
 * @Description:
 */
public class Leecode278 {


    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int res = n;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                right =mid-1;
            }else{
                left = mid+1;
            }
        }
        return  left;

    }
    boolean isBadVersion(int version){
        return true;
    }
}
