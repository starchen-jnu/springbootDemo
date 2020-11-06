package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/27 11:08
 * @Description:�ۼ���
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
            //�����յ㣬�ж��Ƿ������� 3 ����
            return index > 2;
        }
        long num = 0;
        //�� len ���ж��Ƿ���� 01 �������
        int len = 0;
        for (int i = start; i < chars.length; i++) {
            num *= 10;
            num += chars[i] - '0';
            len++;
            if (String.valueOf(num).length() < len) {
                //������ 01 ����������ǲ�����ģ�ֱ�ӷ��� false
                return false;
            }
            path[index] = num;
            //�����ǰ���ۼ�������С�� 3 �����Ͳ����ж��Ƿ����㹹���ۼ�����Ҫ��
            if (index < 2) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
                continue;
            }
            //��ǰ���ۼ����������ڵ��� 3 ������Ҫ�ж��Ƿ���������
            if (path[index] == path[index - 1] + path[index - 2]) {
                if (dfs(chars, i + 1, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }



    //�������������㷨
    public boolean isAdditiveNumber2(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        long num1, num2;
        //��ʼ����Ҫ���㣺1?��ͷ����Ϊ0??2?���Ȳ������ܳ���һ��
        for (int i=0; i<num.length()/2; i++) {
            //?�߽磺��һ������ʼ�Ƿ�Ϊ0���Ҳ�ֹһλ
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }

            num1 = getNum(num, 0, i);

            for (int j=i+1; j<num.length(); j++) {
                //�߽磺�ڶ�������ʼ�Ƿ�Ϊ0���Ҳ�ֹһλ
                if (num.charAt(i+1) == '0' && j > i+1) {
                    break;
                }
                num2 = getNum(num, i+1, j);
                //?����
                if (isValid(num, j+1, num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    //ǰ��������ӵ��ڵ��������������������false
    private boolean isValid(String num, int start, long num1, long num2) {
        long target = num1 + num2;
        int length = String.valueOf(target).length();

        if (getNum(num, start, start + length - 1) != target) {
            return false;
        }
        //�ۼ����ʱ�������к����ıȽϣ�ֱ�����ַ����Ƚ���
        start += length;
        return start == num.length() || isValid(num, start, num2, target);
    }

    //��ȡ��ǰ����
    private long getNum(String num, int start, int end) {
        if (end >= num.length()) {
            return -1;
        }

        long res = Long.parseLong(num.substring(start, end+1));
        return res;
    }




}
