package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/30 16:36
 * @Description:
 */
public class Leecode14 {

    public static void main(String[] args) {
        new Leecode14().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    public String longestCommonPrefix(String[] strs) {

        int minLength = Integer.MAX_VALUE;
        int L = strs.length;
        StringBuffer sb = new StringBuffer("");

        for(int i = 0; i < L-1; i++){
            minLength = Math.min(strs[i].length(),strs[i+1].length());
        }

        for(int j=0;j<minLength;j++){
            for(int i=0;i<L-1;i++){
                if(strs[i].charAt(j) != strs[i+1].charAt(j)){
                    return sb.toString();
                }

            }
            sb.append(strs[0].charAt(j));
        }

        return sb.toString();
    }
}
