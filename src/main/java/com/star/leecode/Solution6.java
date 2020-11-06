package com.star.leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author StarC
 * @Date 2020/10/11 17:00
 * @Description:最长字串(滑动窗口)
 */
public class Solution6 {

    public static void main(String[] args) {
        String s= "abcdads";
        System.out.println(test(s));
    }


        public static int lengthOfLongestSubstring(String s) {
            // 哈希集合，记录每个字符是否出现过
            Set<Character> occ = new HashSet<Character>();
            int n = s.length();
            // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
            int rk = -1, ans = 0;
            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    // 左指针向右移动一格，移除一个字符
                    occ.remove(s.charAt(i - 1));
                }
                while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                    // 不断地移动右指针
                    occ.add(s.charAt(rk + 1));
                    ++rk;
                }
                // 第 i 到 rk 个字符是一个极长的无重复字符子串
                ans = Math.max(ans, rk - i + 1);
            }
            return ans;
        }

        public static Integer test(String s){

        List<String> list = new ArrayList<>();
        int n = s.length();
        Set<Character> character = new HashSet<>();
        int index = -1,ans = 0;
        for(int i=0;i<n;++i){

            StringBuilder sb = new StringBuilder();
            if(i!=0){
                character.remove(s.charAt(i-1));
            }

            while(index+1<n && !character.contains(s.charAt(index+1))){
                character.add(s.charAt(index+1));
                index++;
            }

            for(int j = i;j<=index;j++){
                sb.append(s.charAt(j));
            }
            //获取最长的字符串
            list.add(sb.toString());
            ans = Math.max(ans,index-i+1);
        }
        return ans;
        }
    }


