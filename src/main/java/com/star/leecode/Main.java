package com.star.leecode;

/**
 * @Author StarC
 * @Date 2020/11/2 16:01
 * @Description:
 */
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().trim().split(" ");
        int len = Integer.parseInt(info[0]);
        int aim = Integer.parseInt(info[1]);
        String[] ss = br.readLine().trim().split(" ");
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(ss[i]);
        }
        int res = findMin(arr,aim);
        System.out.println(res);
    }
    public static int findMin(int[] arr,int aim){
        if(arr==null||arr.length==0||aim<0) return -1;
        return process(arr,0,aim);
    }

    //递归弹栈的过程
    public static int process(int[] arr,int i,int rest){
        if(i==arr.length){
            return rest==0?0:Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;//初始值为Integer.MAX_VALUE，如果最后next=0,前面的值返回都是Integer.MAX_VALUE；
        for(int k=0;k*arr[i]<=rest;k++){
            int next = process(arr,i+1,rest-k*arr[i]);

            //递归条件：只有最后next==0时，才能行k值相加。
            //如果最后条件为-1，只返回的都是Integer.MAX_VALUE，不做统计
            if(next!=Integer.MAX_VALUE){

                System.out.println("res:"+res);
               // res = res==-1?next+k:Math.min(next+k,res);
                res = Math.min(next+k,res);



            }
        }
        return res;
    }
}

