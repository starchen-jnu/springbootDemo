package com.star.springbootdemo.leecode;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: StarC
 * @Date: 2020/4/14 20:06
 * @Description:
 */
public class Leecode171 {

    public static void main(String[] args) {
        //titleToNumber("AA");
        reverseWords("  a   good   example   ");
    }
    public static int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for(int i =0;i<len;i++){
            res *= 26;
            int value = s.charAt(i)-'A'+1;
            res += value;
        }
        return res;

    }

    public static String reverseWords(String s) {

        String[] target = s.trim().split(" ");
        List<String> list = Arrays.asList(target);
        List<String> collectList = list.stream().filter(a -> !a.equals("")).collect(Collectors.toList());
        Collections.reverse(collectList);
        String join =  StringUtils.join(collectList, " ");
        System.out.println(join);
        return join;

    }
}
