package com.star.springbootdemo.algorithm.queue;

/**
 * @Author: StarC
 * @Date: 2020/3/8 15:23
 * @Description:
 */
public class Myqueue {

    private int[] arr;
    private int elements;
    private int front;
    private int end;

    public Myqueue(){
        arr = new int[10];
        elements = 0;
        front = 0;
        end = -1;
    }

    public Myqueue(int maxSize){
        arr = new int[maxSize];
        elements = 0;
        front = 0;
        end = -1;
    }

    public void insert(int value){
        /*if(end == arr.length-1){
            end = -1;
        }*/
        arr[++end] = value;
        elements++;
    }

    public int remove(){

        if(front < 0){
            throw new RuntimeException("异常");
        }
        return arr[front--];
    }

    public int peek(){
        return arr[front];
    }

    public boolean isEmpty(){
        return  elements == 0;
    }

    public boolean isFull(){
        return elements == arr.length;
    }


}
