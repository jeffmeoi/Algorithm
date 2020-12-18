package com.jeff.leetcode.math;

public class Problem_17_09_GetKthMagicNumberLCCI {

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[0] = 1;
        int m3 = 0, m5 = 0, m7 = 0;
        for(int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(dp[m3]*3, dp[m5]*5), dp[m7]*7);
            if(dp[i] == dp[m3]*3)
                m3++;
            if(dp[i] == dp[m5]*5)
                m5++;
            if(dp[i] == dp[m7]*7)
                m7++;
        }
        return dp[k-1];
    }

    public static void main(String[] args) {

        Problem_17_09_GetKthMagicNumberLCCI problem_17_09_getKthMagicNumberLCCI = new Problem_17_09_GetKthMagicNumberLCCI();
        System.out.println(problem_17_09_getKthMagicNumberLCCI.getKthMagicNumber(5));       // 9
        System.out.println(problem_17_09_getKthMagicNumberLCCI.getKthMagicNumber(7));       // 21
    }
}
