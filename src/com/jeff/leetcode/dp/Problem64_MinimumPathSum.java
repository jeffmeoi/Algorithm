package com.jeff.leetcode.dp;

/**
 * mat[i][j] 表示走到i,j的数字和
 */
public class Problem64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] mat = new int[m][n];

        for(int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    mat[i][j] = grid[i][j];
                } else if(j == 0) {
                    mat[i][j] = mat[i - 1][j] + grid[i][j];
                } else if(i == 0) {
                    mat[i][j] = mat[i][j - 1] + grid[i][j];
                } else {
                    mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + grid[i][j];
                }
            }
        return mat[m-1][n-1];
    }

    public static void main(String[] args) {
        Problem64_MinimumPathSum problem64 = new Problem64_MinimumPathSum();
        System.out.println(problem64.minPathSum(new int[][]{new int[]{1,3,1},new int[]{1,5,1}, new int[]{4,2,1}}));     // 7
        System.out.println(problem64.minPathSum(new int[][]{new int[]{1,2,3},new int[]{4,5,6}}));                       // 12
    }
}
