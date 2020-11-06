package com.star.leecode;

import java.util.Arrays;

/**
 * @Author StarC
 * @Date 2020/11/4 11:00
 * @Description:栈通过数组实现
 */
public class StackByArray {

    int size = 0;
    int[] array;

    public StackByArray(){
        this(10);
    }
    public StackByArray(int i){
        if(i<10){
            i=10;
        }
        array = new int[i];
    }

    public void push(int item){
        if(array.length == size){
            array = Arrays.copyOf(array,size*2);
        }
        array[size++] = item;

    }

    public int peek(){
        if(size<=0){
            throw new ArrayIndexOutOfBoundsException("栈已空");
        }
        return array[size-1];
    }
    public int pop(){
        int res = peek();
        size--;
        return res;
    }

    public boolean isFull(){
        return size == array.length;
    }

    public boolean isEmpty(){
        return array.length==0;
    }

    public int size(){
        return size;
    }



}
