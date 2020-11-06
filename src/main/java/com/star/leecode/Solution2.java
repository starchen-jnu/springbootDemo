package com.star.leecode;



/**
 * @Author StarC
 * @Date 2020/10/10 20:28
 * @Description:版本比较
 */
public class Solution2 {

    public static void main(String[] args) {

        String s1 ="1.0.01";
        String s2 = "1.0.2";
        System.out.println(compareVersion(s1,s2));
    }
    public static Integer compareVersion(String s1,String s2){
        String[] str1 = s1.split("\\.");
        String[] str2 =s2.split("\\.");
        for(int i =0;i< Math.max(str1.length,str2.length);i++){
            int j = (i<str1.length?Integer.valueOf(str1[i]):0);
            int k = (i<str2.length?Integer.valueOf(str2[i]):0);
            if(j>k) return 1;
            if(j<k) return -1;
        }
        return 0;
    }
}
