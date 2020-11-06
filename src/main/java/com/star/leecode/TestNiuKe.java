package com.star.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author StarC
 * @Date 2020/10/20
 * @Description:
 */
public class TestNiuKe {
    public static void main(String[] args) {

       /* Map<String,String> map = new HashMap<>();
        for (int i =0;i<12;i++){
            if(i<11) {
                map.put("star" + i, "male" + i);
            }else {
                map.put("starend" , "male" + i);
            }
        }*/

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Integer s = stack.peek();
        s = 5;
        System.out.println(stack.peek());
        System.out.println(stack.peek());


    }
}
