package com.jeff.leetcode.dp;

import java.util.Arrays;

/**
 * dp[i]表示总额为i情况下需要的最少硬币数
 * 边界条件位dp[0]=0
 * 转移方程为dp[j] = min(dp[j], dp[i-coins[i]]+1)
 */
public class Problem322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for(int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        if(dp[amount] == 10001)
            return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        Problem322_CoinChange problem322_coinChange = new Problem322_CoinChange();
        System.out.println(problem322_coinChange.coinChange(new int[]{1, 2, 5}, 11));   // 3
        System.out.println(problem322_coinChange.coinChange(new int[]{2}, 3));          // -1
        System.out.println(problem322_coinChange.coinChange(new int[]{1}, 0));          // 0
        System.out.println(problem322_coinChange.coinChange(new int[]{1}, 1));          // 1
        System.out.println(problem322_coinChange.coinChange(new int[]{1}, 2));          // 2
    }
}
