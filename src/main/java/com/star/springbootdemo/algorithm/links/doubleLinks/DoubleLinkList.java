package com.star.springbootdemo.algorithm.links.doubleLinks;

import com.star.springbootdemo.algorithm.links.Node;

/**
 * @Author: StarC
 * @Date: 2020/3/8 15:59
 * @Description:双端链表
 */
public class DoubleLinkList {

    //头结点
    private Node first;
    //尾结点
    private Node last;

    public DoubleLinkList(){

        first = null;
        last = null;
    }

    //插入一个节点，在头结点后插入
    public void insertFirst(long value){
        Node node = new Node(value);
        if(isEmpty()){
            last = node;
        }
        node.next = first;
        first = node;
    }

    //插入一个节点，在尾结点后插入
    public void insertLast(long value){
        Node node = new Node(value);
        if(isEmpty()){
            first = node;
        }else{
            last.next = node;
        }
        last = node;
    }

    public Node deleteFirst(){
        Node tmp = first;
        if(first.next == null){
            last = null;
        }
        first = tmp.next;
        return tmp;


    }

    public void display(){
        Node current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }

    public Node find(long value) {
        Node current = first;
        while(current.data != value){
           if(current.next == null){
               return  null;
           }
           current = current.next;
        }
        return current;
    }

    public Node delete(long value){
        Node current = first;
        Node previous = first;
        while(current.data != value){
            if(current.next == null){
                return  null;
            }
            previous = current;
            current = current.next;
        }
        if(current == first){
            first = first.next;
        }else{
            previous.next = current.next;

        }
        return current;
    }

    public boolean isEmpty(){

        return first == null;
    }




}
