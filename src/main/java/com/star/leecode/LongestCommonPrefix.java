package com.star.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author StarC
 * @Date 2020/10/13 19:56
 * @Description:
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] s = {"dog","docecar","dor"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(s));
    }

    public String longestCommonPrefix(String[] strs) {

        int minlen = Integer.MAX_VALUE;
        int len = strs.length;
        if(len < 1 ){
            return "";
        }
        if(len == 1  ){
            return strs[0];
        }
        for(int i =0;i<strs.length;i++){
            minlen = Math.min(minlen,strs[i].length());
        }
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<minlen;i++){
            char str = strs[0].charAt(i);
            for(int j=0;j<len;j++){
                if(str != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> allList = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                for(int k= j+1;k<len;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){

                        allList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }

        return allList;


    }
}
