package com.star.springbootdemo.leecode;

import java.util.Arrays;

/**
 * @Author: StarC
 * @Date: 2020/5/6 15:14
 * @Description:金币兑换
 */
public class Leecode322 {


    public static void main(String[] args) {
        Leecode322 leecode322 = new Leecode322();
        leecode322.coinChange2(new int[]{1,3,2,4,5},6);
    }

    //动态规划
    public int coinChange(int[] coins, int amount) {

        int length = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        int i = dp[amount]>amount?-1:dp[amount];
        return i;
    }


    //回溯算法
    public int coinChange2(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;

    }

    int res = Integer.MAX_VALUE;
    public int coinChange3(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }

        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }



    int ans = Integer.MAX_VALUE;

    //贪心+dfs算法
    public int coinChange4(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length-1, coins, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChange(int index, int[] coins, int count, int needAmount) {
        if (needAmount == 0) {
            ans = Math.min(count, ans);
            return;
        }
        if (index < 0) {
            return;
        }

        int i = needAmount / coins[index];
        for (int k=i; k>=0 && count+k<ans; k--) {
            coinChange(index-1, coins, count+k, needAmount-k*coins[index]);
        }
    }




}
