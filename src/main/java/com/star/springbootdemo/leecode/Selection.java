package com.star.springbootdemo.leecode;

import java.util.Arrays;

/**
 * @Author: StarC
 * @Date: 2020/5/15 16:47
 * @Description:
 */
public class Selection {
    public static void main(String[] args) {
        sort(new int[]{2,1,4,5,6});
    }


    public static void sort(int[] arr){

        for(int i = 0;i < arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1;j <= arr.length-1; j++){
                minIndex = arr[minIndex]<arr[j]?minIndex:j;
            }
            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
