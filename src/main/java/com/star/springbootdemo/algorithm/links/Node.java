package com.star.springbootdemo.algorithm.links;

/**
 * @Author: StarC
 * @Date: 2020/3/8 15:56
 * @Description:
 */
public class Node {
    //数据域
    public long data;
    //指针域
    public Node next;

    public Node(long data){
        this.data = data;
    }

    public void display(){
        System.out.println(data+"");
    }


}
