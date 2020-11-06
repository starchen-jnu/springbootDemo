package com.star.springbootdemo.algorithm.doubledirecttionlink;

import lombok.Data;

/**
 * @Author: StarC
 * @Date: 2020/3/10 14:53
 * @Description:
 */

public class Node {

    public int data;
    public Node next;
    public Node previous;

    public Node(int data){
        this.data = data;
    }


    public void show(){
        System.out.println(data+" ");
    }

}
