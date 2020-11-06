package com.star.springbootdemo.algorithm.leecode;

import java.util.Scanner;

/**
 * @Author: StarC
 * @Date: 2020/3/27 15:22
 * @Description:
 */
public class Leecode70 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println("请输入楼梯数");
            int n = scanner.nextInt();
            long beginTime = System.currentTimeMillis();
            System.out.println(goUpstair(n));
            long endTime = System.currentTimeMillis();
            System.out.println("耗时："+(endTime-beginTime));
        }

    }

    public static int goUpstair(int n){
        if(n==1 || n==0){
            return 1;
        }

        int sum1 = goUpstair(n-1);
        int sum2 = goUpstair(n-2);
        return sum1+sum2;
    }

    /*//动态规划
    public static int godpUpstair(int n){

    }*/
}
