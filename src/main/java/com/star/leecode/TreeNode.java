package com.star.leecode;

import java.util.Stack;

/**
 * @Author StarC
 * @Date 2020/10/29 15:35
 * @Description:非递归实现二叉树
 */
public class TreeNode {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l = new Node(2);
        Node r = new Node(3);
        Node ll = new Node(4);
        Node lr = new Node(5);
        Node rl = new Node(6);
        Node rr = new Node(7);
        root.leftChild = l;
        root.rightChild = r;
        l.leftChild = ll;
        l.rightChild = lr;
        r.leftChild = rl;
        r.rightChild = rr;
        preOrder(root);
       // recursivepreOrder(root);
        recursiveinOrder(root);
        //recursivepostOrder(root);

    }

    //后序
    public static void postOrder(Node Root) {
        if(Root==null) {
            System.out.println("空树");
            return;
        }
        Node tmp=Root;  //当前节点
        Node prev=null; //上一次访问的节点
        Stack<Node> s=new Stack<Node>();
        while(tmp!=null || !s.empty()) {
            //1.将根节点及其左孩子入栈
            while(tmp!=null) {
                s.push(tmp);
                tmp=tmp.leftChild;
            }

            if(!s.empty()) {
                //2.获取栈顶元素值
                tmp=s.peek();
                //3.没有右孩子，或者右孩子已经被访问过
                if(tmp.rightChild==null || tmp.rightChild==prev) {
                    //则可以访问栈顶元素
                    tmp=s.pop();
                    System.out.print(tmp.data+" ");
                    //标记上一次访问的节点
                    prev=tmp;
                    tmp=null;
                }
                //4.存在没有被访问的右孩子
                else {
                    tmp=tmp.rightChild;
                }
            }
        }
        System.out.println();
    }

    //中序
    public static void inOrder(Node Root) {
        if(Root==null) {
            System.out.println("空树");
            return;
        }
        Node tmp=Root;
        Stack<Node> s=new Stack<Node>();
        while(tmp!=null || !s.empty()) {
            //1.将根节点入栈
            //2.将所有左孩子入栈
            while(tmp!=null) {
                s.push(tmp);
                tmp=tmp.leftChild;
            }
            //3.访问栈顶元素
            tmp=s.pop();
            System.out.print(tmp.data+" ");
            //4.如果栈顶元素存在右孩子，则将右孩子赋值给tmp，也就是将右孩子入栈
            if(tmp.rightChild!=null) {
                tmp=tmp.rightChild;
            }
            //否则，将tmp置为null，表示下次要访问的是栈顶元素
            else {
                tmp=null;
            }
        }
        System.out.println();
    }

    //前序
    public static void preOrder(Node Root) {
        if(Root==null) {
            System.out.println("空树");
            return;
        }
        Node tmp=Root;
        Stack<Node> s=new Stack<Node>();
        s.push(tmp);  //根节点入栈
        while(!s.empty()) {
            //1.访问根节点
            Node p=s.pop();
            System.out.print(p.data+" ");
            //2.如果根节点存在右孩子，则将右孩子入栈
            if(p.rightChild!=null) {
                s.push(p.rightChild);
            }
            //3.如果根节点存在左孩子，则将左孩子入栈
            if(p.leftChild!=null) {
                s.push(p.leftChild);
            }
        }
        System.out.println();
    }


    //递归
    //前序

    public static void recursivepreOrder(Node Root){
        System.out.print(Root.data+" ");
        if(Root.leftChild != null){
            recursivepreOrder(Root.leftChild);
        }
        if(Root.rightChild != null){
            recursivepreOrder(Root.rightChild );
        }
    }

    public static void recursiveinOrder(Node Root){

        if(Root.leftChild != null){
            recursiveinOrder(Root.leftChild);
        }
        System.out.print(Root.data+" ");
        if(Root.rightChild != null){
            recursiveinOrder(Root.rightChild );
        }
    }

    public static void recursivepostOrder(Node Root){

        if(Root.leftChild != null){
            recursivepostOrder(Root.leftChild);
        }

        if(Root.rightChild != null){
            recursivepostOrder(Root.rightChild );
        }

        System.out.print(Root.data+" ");
    }
}
