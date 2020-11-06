package com.star.leecode;

import sun.security.util.Length;

/**
 * @Author StarC
 * @Date 2020/10/11 15:49
 * @Description:回文数
 */
public class Solution5 {

    public static void main(String[] args) {
        int num = 1233212;
        String nums = "-123321";
        System.out.println(isparad(num));
        System.out.println(isparad(nums));
    }

    public static boolean isparad(int num){
        if(num<0){
            return false;
        }

        int startNum = num;
        int reversNum = 0;
        while(num != 0){
            reversNum = reversNum*10+num%10;
            num /= 10;
        }

        if (reversNum==startNum){
            return true;
        }
        return false;
    }

    public static boolean isparad(String num){
        char[] chars = num.toCharArray();
        if(chars[0] == '-'){
            return false;
        }
        for(int i=0;i<= (num.length()-1)/2;i++){
            if(chars[i] != chars[num.length()-1-i]){
                return false;
            }
        }
        return true;
    }
}
