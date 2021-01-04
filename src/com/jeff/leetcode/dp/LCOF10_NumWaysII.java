package com.jeff.leetcode.dp;

public class LCOF10_NumWaysII {
    public int numWays(int n) {
        int[] dp = new int[n+2];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = ( dp[i-1] + dp[i-2] ) % 1000000007;
        return dp[n];
    }

    public static void main(String[] args) {
        LCOF10_NumWaysII p = new LCOF10_NumWaysII();
        System.out.println(p.numWays(2));       // 2
        System.out.println(p.numWays(7));       // 21
        System.out.println(p.numWays(0));       // 1
    }
}
