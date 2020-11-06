package com.star.springbootdemo.uuid;

/**
 * @Author StarC
 * @Date 2020/10/11 10:14
 * @Description:
 */
public class test {

    public static void main(String[] args) {
        //System.out.println(getRouteNums(3,3));
        
    }



    //无障碍物
    public static Integer getRouteNums(Integer m,Integer n){
        Integer[][]dp = new Integer[m][n];
        for(Integer i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for (Integer i=0;i<n;i++){
            dp[0][i]=1;
        }

        for(Integer i=1;i<m;i++){
            for (Integer j =1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    //障碍物
    public static Integer getRouteNums(Integer[][]barrier,Integer m,Integer n){
        Integer[][]dp = new Integer[m][n];
        for(Integer i=0;i<m;i++){
            dp[i][0] = barrier[i][0]==1?0:1;
        }

        for (Integer i=0;i<n;i++){
            dp[0][i]=barrier[0][i]==1?0:1;
        }

        for(Integer i=1;i<m;i++){
            for (Integer j =1;j<n;j++){
                dp[i][j] = barrier[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
