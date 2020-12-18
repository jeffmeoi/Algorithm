package com.jeff.leetcode.dp;

/**
 * mat[i][j] 表示从mat[1][1](起点)到mat[i][j]的路径数
 */
public class Problem62_UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] mat = new int[m+1][n+1];
        for(int i = 1; i <= m; i++)
            mat[i][1] = 1;
        for(int i = 1; i <= n; i++)
            mat[1][i] = 1;

        for(int i = 2; i <= m; i++)
            for (int j = 2; j <= n; j++)
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
        return mat[m][n];
    }

    public static void main(String[] args) {
        Problem62_UniquePaths problem62 = new Problem62_UniquePaths();
        System.out.println(problem62.uniquePaths(3, 7));        // 28
        System.out.println(problem62.uniquePaths(3, 2));        // 3
        System.out.println(problem62.uniquePaths(7, 3));        // 28
        System.out.println(problem62.uniquePaths(3, 3));        // 6
    }
}
