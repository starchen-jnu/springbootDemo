package com.star.springbootdemo.algorithm.stack;

/**
 * @Author: StarC
 * @Date: 2020/3/8 15:13
 * @Description:
 */
public class Mystack {

    private int[] arr;
    private int top;

    public Mystack(){
        arr = new int[10];
        top = -1;
    }

    public Mystack(int maxSize){
        arr = new int[maxSize];
        top =-1;
    }

    public void push(int value){
        arr[++top] = value;
    }

    public int pop(){
        return arr[top--];
    }

    public int peek(){

        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){

        return top == arr.length-1;
    }




}
