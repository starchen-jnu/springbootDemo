package com.star.leecode;

import java.util.Stack;

/**
 * @Author StarC
 * @Date 2020/10/10 16:58
 * @Description:解码
 */
class Solution {

    public static void main(String[] args) {
        String s = "2[1[abc]1[cd]ef]";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        int multi=0;
        Stack<Integer> multi_stack=new Stack<>();
        Stack<String> res_stack=new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c>='0'&&c<='9')
            {
                //只有字符串才可以paseint
                multi=multi*10+Integer.parseInt(c+"");
            }else if(c=='[')
            {
                multi_stack.push(multi);
                res_stack.push(res.toString());
                multi=0;
                res=new StringBuilder();
            }else if(c==']')
            {
                StringBuilder temp=new StringBuilder();
                int cur_multi=multi_stack.pop();
                for(int i=cur_multi;i>0;i--)
                {
                    temp.append(res);
                }
                res=new StringBuilder(res_stack.pop()+temp.toString());
            }else
            {
                res.append(c);
            }
        }
        return res.toString();
    }
}
