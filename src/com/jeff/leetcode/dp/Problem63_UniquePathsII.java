package com.jeff.leetcode.dp;

/**
 * mat[i][j]表示走到i,j可行的路径数量
 */
public class Problem63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] mat = new int[m][n];

        for(int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0 && obstacleGrid[i][j] == 0)
                    mat[i][j] = 1;
                else if (obstacleGrid[i][j] == 0)
                    mat[i][j] = (i>=1 ? mat[i - 1][j] : 0) + (j >= 1 ? mat[i][j - 1] : 0);
            }
        return mat[m-1][n-1];
    }

    public static void main(String[] args) {
        Problem63_UniquePathsII problem63 = new Problem63_UniquePathsII();
        System.out.println(problem63.uniquePathsWithObstacles(new int[][]{new int[]{1, 0}}));   // 0
        System.out.println(problem63.uniquePathsWithObstacles(new int[][]{new int[]{0, 0, 0}, new int[]{0,1,0}, new int[]{0,0,0}}));    // 2
        System.out.println(problem63.uniquePathsWithObstacles(new int[][]{new int[]{0, 1}, new int[]{0,0}}));   // 1
    }
}
