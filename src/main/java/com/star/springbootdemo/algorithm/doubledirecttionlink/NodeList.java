package com.star.springbootdemo.algorithm.doubledirecttionlink;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: StarC
 * @Date: 2020/3/10 14:56
 * @Description:
 */
public class NodeList {

    private Node first;
    private Node last;

    public NodeList() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        if(isFirst()){
            last = node;
        }else{
            first.previous = node;
        }
        node.next = first;
        first = node;
    }
    public void insertLast(int value){
        Node node = new Node(value);
        if(isFirst()){
            first = node;
        }else{
            last.next = node;
            node.previous = last;
        }
        last = node;
    }

    public Node deleteFirst(){
        Node tmp = first;
        if(first.next == null){
            last = null;
        }else{
            tmp.next.previous =null;
        }
        first = tmp.next;
        return tmp;
    }

    public Node deleteLast(){

        Node temp = first;
        if(first.next == null){
            first = null;
        }else{
            last.previous.next = null;
        }
        last = last.previous;
        return last;
    }

    public Node find(int value){
        Node current = first;
        while(current.data != value ){
            if(current.next == null){
                return null;
            }
            current.previous = current;
            current = current.next;
        }
        return current;
    }

    public Node delete(int value){
        Node current = first;
        while(current.data != value ){
            if(current.next == null){
                return null;
            }
            current.previous = current;
            current = current.next;
        }
        if(current == first){
            first = first.next;
        }else{
            current.previous.next = current.next;
        }
        return current;
    }


    public void display(){

        Node current = first;
        while(current != null){
            current.show();
            current = current.next;
        }
    }



    public boolean isFirst(){

        return first == null;
    }



}
