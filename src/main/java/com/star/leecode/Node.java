package com.star.leecode;

import lombok.Data;

/**
 * @Author StarC
 * @Date 2020/10/29 15:34
 * @Description:
 */

public class Node {
    int data;   //节点值
    Node leftChild;  //左孩子
    Node rightChild; //右孩子
    public Node(int data) {
        this.data=data;
    }
}
