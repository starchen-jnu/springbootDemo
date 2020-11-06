package com.star.springbootdemo.algorithm.doubledirecttionlink;

/**
 * @Author: StarC
 * @Date: 2020/3/10 15:47
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        NodeList nodeList = new NodeList();
        nodeList.insertFirst(12);
        nodeList.insertFirst(20);
        nodeList.insertFirst(30);
        nodeList.delete(20);
        nodeList.display();
    }

}
