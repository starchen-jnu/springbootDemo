package com.star.leecode;

/**
 * @Author StarC
 * @Date 2020/10/11 9:47
 * @Description:办公室路线
 */
public class Solution4 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }
        public static int uniquePaths(int m, int n) {
            if(m < 0 || n < 0)
                return 0;
            int dp[][] = new int[m][n];
            //初始化
            dp[0][0] = 0;
            //初始化列
            for(int i = 0;i<n;i++){
                dp[0][i] = 1;
            }
            //初始化行
            for(int i = 0;i<m;i++){
                dp[i][0] = 1;
            }
            //动态规划
            for(int i =1;i<m;i++){
                for(int j = 1;j<n;j++){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }


}
