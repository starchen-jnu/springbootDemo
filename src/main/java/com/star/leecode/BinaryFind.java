package com.star.leecode;

import java.util.Arrays;

/**
 * @Author StarC
 * @Date 2020/10/29 18:52
 * @Description:
 */
public class BinaryFind {


    public static void main(String[] args) {

        int []nums = {1,2};
        int target = 2;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {


        if(nums.length==1 && nums[0] == target){
            return new int[]{0,0};
        }
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (end+start)/2;
            if(nums[mid] == target){
                if(mid !=start &&mid !=end){
                    if(nums[mid-1] == target && nums[mid+1] == target){
                        return new int[]{mid-1,mid+1};
                    }else if(nums[mid-1] == target && nums[mid+1] != target){
                        return new int[]{mid-1,mid};
                    }else if(nums[mid-1] != target && nums[mid+1] == target){
                        return new int[]{mid,mid+1};
                    }else if(nums[mid-1] != target && nums[mid+1] != target){
                        return new int[]{mid,mid};
                    }
                }else if(mid == start){
                    if(nums[start+1]==target){
                        return new int[]{mid,mid+1};
                    }else {
                        return new int[]{mid,mid};
                    }
                }else if(mid == end){
                    if(nums[mid-1]==target){
                        return new int[]{mid-1,mid};
                    }else {
                        return new int[]{mid-1,mid-1};
                    }
                }
            }else if(nums[mid] > target){
                end = mid -1;
            }else if(nums[mid] < target){
                start = mid +1;
            }
        }

        return new int[]{-1,-1};
    }
}
