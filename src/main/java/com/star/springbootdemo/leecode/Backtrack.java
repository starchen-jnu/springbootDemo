package com.star.springbootdemo.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: StarC
 * @Date: 2020/4/23 14:28
 * @Description: À¨ºÅ×éºÏ
 */
public class Backtrack {

    public static void main(String[] args) {
        new Backtrack().generateParenthesis(4);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, n, 0, "");
        return list;
    }

    public static void backtrack(List<String> list, int left, int right, String str){
        if(left==0 && right==0){
            list.add(str);
        }else{
            if(left>0){
                backtrack(list,left-1,right+1,str+"(");
            }
            if(right>0){
                backtrack(list,left,right-1,str+")");
            }
        }
    }

}
