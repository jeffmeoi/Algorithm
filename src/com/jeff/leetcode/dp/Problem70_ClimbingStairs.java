package com.jeff.leetcode.dp;

/**
 * dp[i] 表示爬到第i阶的路径数
 */
public class Problem70_ClimbingStairs {

    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        if(n >= 1)    dp[1] = 1;
        if(n >= 2)  dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem70_ClimbingStairs problem70 = new Problem70_ClimbingStairs();
        System.out.println(problem70.climbStairs(2));       // 2
        System.out.println(problem70.climbStairs(3));       // 3
    }
}
