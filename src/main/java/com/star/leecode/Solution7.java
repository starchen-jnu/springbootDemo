package com.star.leecode;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author StarC
 * @Date 2020/10/11 17:45
 * @Description:
 */
public class Solution7 {
    public static void main(String[] args) {
        Integer[]  nums1 = {1,3};
        Integer[] nums2 = {};
        System.out.println(findMedianSortedArrays(nums1,nums2));;
    }
    public static double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
        List<Integer> numslist1 = Arrays.asList(nums1);
        List<Integer> numslist2  = Arrays.asList(nums2);
        List<Integer> list = new ArrayList<>();
        list.addAll(numslist1);
        list.addAll(numslist2);
        list.stream().filter(x->x != null);
        Collections.sort(list);
        int n = list.size();
        double target = 0L;
        if(n %2==0){
            target = (list.get(n/2)+list.get(n/2-1))/2;
        }else {
            target = list.get(n/2)/2;
        }
        return target;

    }
}
