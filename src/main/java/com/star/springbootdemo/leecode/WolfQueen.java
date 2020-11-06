package com.star.springbootdemo.leecode;

/**
 * @Author: StarC
 * @Date: 2020/4/26 9:31
 * @Description:�˻ʺ��㷨
 */


/**
 * Created by wolf on 2016/3/16.
 */
public class WolfQueen {
    /**
     * һ���ж��ٸ��ʺ󣨴�ʱ����Ϊ8�ʺ���8X8���̣������޸Ĵ�ֵ������N�ʺ����⣩
     */
    int max = 8;
    /**
     * �����鱣��������һ���ʺ����array[0]�У��ڶ�������array[1]��
     */
    int[] array = new int[max];

    public static void main(String[] args) {
        new WolfQueen().check(0);
    }

    /**
     * n����ǰ�ǵڼ����ʺ�
     * @param n
     * �ʺ�n��array[n]��
     */
    private void check(int n) {
        //��ֹ���������һ���Ѿ����꣬����ÿ��һ������У���Ƿ��г�ͻ������ֻҪ���һ�а��꣬˵���Ѿ��õ���һ����ȷ��
        if (n == max) {
            print();
            return;
        }
        //�ӵ�һ�п�ʼ��ֵ��Ȼ���ж��Ƿ�ͱ��б��б�б���г�ͻ�����OK���ͽ�����һ�е��߼�
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private void print()  {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println("---------");
    }
}
