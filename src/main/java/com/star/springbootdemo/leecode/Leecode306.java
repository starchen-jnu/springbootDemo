package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/27 11:08
 * @Description:累加数
 */
public class Leecode306 {

    long[] path;
    public boolean isAdditiveNumber(String num) {
        char[] chars = num.toCharArray();
        path = new long[1000];
        return dfs(chars, 0, 0);
    }

    public boolean dfs(char[] chars, int start, int index) {
        if (start == chars.length) {
            //到达终点，判断是否有至少 3 个数
            return index > 2;
        }
        long num = 0;
        //用 len 来判断是否存在 01 这种情况
        int len = 0;
        for (int i = start; i < chars.length; i++) {
            num *= 10;
            num += chars[i] - '0';
            len++;
            if (String.valueOf(num).length() < len) {
                //出现了 01 这种情况，是不允许的，直接返回 false
                return false;
            }
            path[index] = num;
            //如果当前的累加数个数小于 3 个，就不用判断是否满足构成累加数的要求
            if (index < 2) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
                continue;
            }
            //当前的累加数个数大于等于 3 个，需要判断是否满足条件
            if (path[index] == path[index - 1] + path[index - 2]) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }



    //方法二，回溯算法
    public boolean isAdditiveNumber2(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        long num1, num2;
        //起始数字要满足：1?开头不能为0??2?长度不超过总长度一半
        for (int i=0; i<num.length()/2; i++) {
            //?边界：第一个数起始是否为0，且不止一位
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }

            num1 = getNum(num, 0, i);

            for (int j=i+1; j<num.length(); j++) {
                //边界：第二个数起始是否为0，且不止一位
                if (num.charAt(i+1) == '0' && j > i+1) {
                    break;
                }
                num2 = getNum(num, i+1, j);
                //?回溯
                if (isValid(num, j+1, num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    //前两个数相加等于第三个数，如果不符返回false
    private boolean isValid(String num, int start, long num1, long num2) {
        long target = num1 + num2;
        int length = String.valueOf(target).length();

        if (getNum(num, start, start + length - 1) != target) {
            return false;
        }
        //累加相等时继续进行后续的比较，直到将字符串比较完
        start += length;
        return start == num.length() || isValid(num, start, num2, target);
    }

    //获取当前数字
    private long getNum(String num, int start, int end) {
        if (end >= num.length()) {
            return -1;
        }

        long res = Long.parseLong(num.substring(start, end+1));
        return res;
    }




}
