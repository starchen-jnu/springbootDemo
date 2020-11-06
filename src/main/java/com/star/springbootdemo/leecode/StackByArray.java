package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/5/22 10:44
 * @Description:数组实现栈
 */
public class StackByArray {

    public int[] arr;


    public StackByArray(){
        arr = new int[0];
    }

    public void push(int value){
        int[] temp = new int[arr.length+1];
        for(int i=0;i<temp.length;i++){
            temp[i] = arr[i];
        }
        temp[arr.length] = value;
        arr = temp;

    }
    public int pop(){
        if(arr.length == 0){
            throw new NullPointerException("栈没有数据");
        }
        int[] temp = new int[arr.length-1];
        for(int i = 0;i<arr.length-1;i++){

            temp[i] = arr[i];
        }
        int value = arr[arr.length-1];
        arr = temp;
        return value;

    }

    public int peek(){
        int value = arr[arr.length-1];
        return value;
    }


}
