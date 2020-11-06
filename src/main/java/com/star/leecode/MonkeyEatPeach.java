package com.star.leecode;

import org.apache.commons.lang3.StringUtils;

import java.util.Queue;

/**
 * @Author StarC
 * @Date 2020/11/4 9:58
 * @Description:
 */
public class MonkeyEatPeach {

    public static void main(String[] args) {
        System.out.println(eatPeach(9));
        System.out.println(eatPeach(7));
        System.out.println(eatPeach1(7));

    }

    public static   int eatPeach(int n){
        if(n==10){
            return 1;
        }
        return 2*(eatPeach(n+1)+1);
    }

    public static   int eatPeach1(int j){

        if(j<0){
            throw new IllegalArgumentException();
        }
      int[] arr = new int[11];
      arr[0] = 0;
      arr[10] = 1;
      for(int i =10;i>1;i--){
         arr[i-1] = 2*(arr[i]+1);
      }
      return arr[j];
    }
}
