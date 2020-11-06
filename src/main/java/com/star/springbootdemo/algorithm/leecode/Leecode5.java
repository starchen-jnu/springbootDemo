package com.star.springbootdemo.algorithm.leecode;

/**
 * @Author: StarC
 * @Date: 2020/3/23 11:04
 * @Description:最长回文数
 */
public class Leecode5 {

    public static void main(String[] args) {

        String s = "aaa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int[] limit = {0, 0};
        char[] ch = s.toCharArray();
        int i = 0;
        while (i < ch.length) {
            i = indexOf(ch, i, limit);
        }
        result = s.substring(limit[0], limit[1]);
        return result;
    }

    public static int indexOf(char[] ch, int low, int[] limit) {
        int high = low + 1;
        while (high < ch.length && ch[high] == ch[low]) {
            high++;
        }
        int result = high;
        while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
            low--;
            high++;
        }

        if (high - low > limit[1] - limit[0]) {
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }
}
