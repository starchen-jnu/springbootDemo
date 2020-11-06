package com.star.springbootdemo.leecode;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/4/24 10:53
 * @Description:�����㷨���Ӽ�
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        //���ս���б�
        List<List<Integer>> list = new ArrayList();
        //��ʼ������start=0
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }
    public void backtrack(List<List<Integer>>list, List<Integer> tempList, int []nums, int start){
        //list�б�����Ӽ�
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
