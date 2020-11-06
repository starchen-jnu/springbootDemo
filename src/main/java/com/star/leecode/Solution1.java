package com.star.leecode;

import java.util.Stack;

/**
 * @Author StarC
 * @Date 2020/10/10 20:07
 * @Description:编码
 */
public class Solution1 {

    public static void main(String[] args) {
        String s = "2[1[abc]1[cd]ef]";
        System.out.println(decodeStr(s));;
    }

    private static String decodeStr(String s) {

        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        StringBuilder res = new StringBuilder();
        Integer mutil = 0;
        for(char c: s.toCharArray()){
            if(c>='0' && c<= '9'){
                mutil = 10*mutil+Integer.valueOf(c+"");
            }else if(c=='['){
                num.push(mutil);
                mutil = 0;
                str.push(res.toString());
                res = new StringBuilder();

            }else if(c==']'){
                Integer val = num.pop();
                StringBuilder sb = new StringBuilder();
                for(int i = val;i>=0;i--){
                    sb.append(res);
                }
                res.append(str.pop()+res.toString());
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
