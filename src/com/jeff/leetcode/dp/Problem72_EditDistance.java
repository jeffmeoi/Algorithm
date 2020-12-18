package com.jeff.leetcode.dp;

/**
 * dp[i][j]表示word1前i个字符和word2前j个字符的编辑距离
 */
public class Problem72_EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        if(m*n == 0)
            return m+n;

        for(int i = 1; i <= m; i++)
            dp[i][0] = i;
        for(int j = 1; j <= n; j++)
            dp[0][j] = j;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]-1));
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        Problem72_EditDistance problem72 = new Problem72_EditDistance();
        System.out.println(problem72.minDistance("horse", "ros"));      // 3
        System.out.println(problem72.minDistance("intention", "execution"));    // 5
    }
}
