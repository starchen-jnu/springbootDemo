package com.star.springbootdemo.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/5/6 14:24
 * @Description:
 */
public class Leecode349 {

    public static void main(String[] args) {
        new Leecode349().intersection(new int[]{1,2,2,1},new int[]{2,2});
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        for(int i=0;i<length1;i++){
            for(int j=0;j<length2;j++){
                if(nums1[i]==nums2[j]){
                    set.add(nums1[i]);
                }
            }
        }
        int setLength = set.size();
        int[] res = new int[setLength];
        List list = new ArrayList(set);

        for(int i =0;i<setLength;i++){
            res[i]= (int) list.get(i);
        }

        return  res;

    }
}
