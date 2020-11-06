package com.star.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author StarC
 * @Date 2020/10/30 13:43
 * @Description:
 */
public class Solution10 {

    public static void main(String[] args) {

        int[] nums = {1,2,3,5,4,2,3,4,5};
        getnNums(nums);
    }

    public static void getnNums(int[] nums){
        Map<Integer,Integer>map = new HashMap<>();
        for(Integer i:nums){
            map.put(i,map.get(i)==null?1:map.get(i)+1);
        }

        map.entrySet().forEach(x->{
            if(x.getValue()<2){
                System.out.println(x.getKey());
            }
        });
    }
}
