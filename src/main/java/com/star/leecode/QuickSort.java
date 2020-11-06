package com.star.leecode;

import java.util.Arrays;
import java.util.Deque;
import java.util.Vector;

/**
 * @Author StarC
 * @Date 2020/10/14 15:13
 * @Description:
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,3,7};
       /* getQuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));*/
        chooseSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public  static  void getQuickSort(int[] arr,int start,int end){
       if(start<end){
           int low = start;
           int high = end;
           int standard = arr[start];

           while(low < high){
               while(low<high && arr[high]>= standard){
                   high--;
               }
               arr[low] = arr[high];

               while(low<high && arr[low]<= standard){
                   low++;
               }
               arr[high] = arr[low];
           }

           arr[low] = standard;

           getQuickSort(arr,start,low);
           getQuickSort(arr,low+1,end);

       }
    }


    //选择排序；
    public static void chooseSort(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            if(i != minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
