package com.star.springbootdemo.leecode;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/4/24 10:53
 * @Description:回溯算法求子集
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        //最终结果列表
        List<List<Integer>> list = new ArrayList();
        //开始方法，start=0
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }
    public void backtrack(List<List<Integer>>list, List<Integer> tempList, int []nums, int start){
        //list列表添加子集
        if(CollectionUtils.isNotEmpty(tempList)) {
            list.add(new ArrayList<>(tempList));
        }
        for(int i = start;i<nums.length;i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.print((new Subsets()).subsets(nums).toString());
    }

}
