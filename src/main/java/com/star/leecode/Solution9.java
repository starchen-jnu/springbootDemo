package com.star.leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author StarC
 * @Date 2020/10/17 9:25
 * @Description:
 */
public class Solution9 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int len = arr.length;
        int conditon = len/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

       /* for(int i=0;i<len;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                int value = map.get(arr[i]);
                value++;
                map.put(arr[i],value);
            }
        }*/


       for(int i=0;i<len-1;i++){
           int num =1;
           if(!map.containsKey(arr[i])){
               for(int j =i+1;j<len;j++){
                   if(arr[j] == arr[i]){
                       num++;
                   }

               }
               map.put(arr[i],num);
           }
       }




       map.entrySet().forEach(x->{
           if(x.getValue()>conditon){
               System.out.println(x.getKey());
           }
       });
    }
}
