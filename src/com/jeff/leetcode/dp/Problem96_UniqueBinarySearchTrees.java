package com.jeff.leetcode.dp;

/**
 * dp[i]表示i个节点的二叉搜索树的数量
 */
public class Problem96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int l = 2; l <= n; l++) {
            for(int i = 1; i <= l; i++) {
                dp[l] += dp[i-1]*dp[l-i];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem96_UniqueBinarySearchTrees problem = new Problem96_UniqueBinarySearchTrees();
        System.out.println(problem.numTrees(3));            // 5
    }

}
