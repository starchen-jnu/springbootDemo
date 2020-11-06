package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/30 14:52
 * @Description:
 */
public class Leecode28 {

    public static void main(String[] args) {
        int i = new Leecode28().strStr("hello", "ll");
        System.out.println(i);
    }


    // erro coding
    public int strStr(String haystack, String needle) {

        int j =0 ;
        if(!haystack.contains(needle)){
            return -1;
        }
        if(haystack.length()==1&&needle.length()==1&&haystack.contains(needle)){
            return 0;
        }
        for(int i=0;i<haystack.length();i++){
            if(j<needle.length() && haystack.charAt(i)== needle.charAt(j) ){

                if(j == needle.length()-1){
                    return i-(needle.length()-1);
                }
                j++;
            }
        }

        return -1;
    }
}
