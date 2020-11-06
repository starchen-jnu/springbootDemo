package com.star.springbootdemo.algorithm;

/**
 * @Author: StarC
 * @Date: 2019/9/2 16:38
 * @Description:
 */
public class Node {

     int data;
     Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node append(Node node){
        Node currentNode = this;
        while(true){
            Node nextNode = currentNode.next;
            if(nextNode == null){
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        return this;
    }

    public void show(){
        Node currentNode = this;
        while(true){
            System.out.print(currentNode.data+" ");
            currentNode = currentNode.next;
            if(currentNode == null)break;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.append(new Node(2));
        node.append(new Node(3));
        node.append(new Node(4));
        node.show();

    }

}
