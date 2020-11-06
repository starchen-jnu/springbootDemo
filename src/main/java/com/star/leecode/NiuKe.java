package com.star.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author StarC
 * @Date 2020/10/18 15:23
 * @Description:
 */
public class NiuKe {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            ArrayList<int[][]> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                    if(matrix[i][j]==1){
                        int[][] xy = new int[1][2];
                        xy[0][0]=i;
                        xy[0][1]=j;
                        al.add(xy);
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp=0;
                    if(matrix[i][j]==0){
                        for (int k = 0; k < al.size(); k++) {
                            temp+=Math.abs(al.get(k)[0][0]-i)+Math.abs(al.get(k)[0][1]-j);
                        }
                        res = res>temp?temp:res;
                    }
                }
            }
            System.out.println(res==Integer.MAX_VALUE?-1:res);
        }
    }

    public int getnums(int []nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
