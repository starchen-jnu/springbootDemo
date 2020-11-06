package com.star.springbootdemo.algorithm.links;

/**
 * @Author: StarC
 * @Date: 2020/3/8 15:59
 * @Description:
 */
public class LinkList {

    private Node first;

    public LinkList(){
        first = null;
    }

    //插入一个节点，在头结点后插入
    public void insertFirst(long value){
        Node node = new Node(value);
        node.next = first;
        first = node;
    }

    public Node deleteFirst(){
        Node tmp = first;
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



}
