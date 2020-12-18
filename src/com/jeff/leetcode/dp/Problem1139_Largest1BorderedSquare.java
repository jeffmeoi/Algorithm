package com.jeff.leetcode.dp;

/**
 * x[i][j]表示x[i][0-j]的sum
 * y[i][j]表示y[0-i][j]的sum
 */
public class Problem1139_Largest1BorderedSquare {

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;
        int x[][] = new int[m+1][n+1];
        int y[][] = new int[m+1][n+1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                x[i][j] = x[i][j-1] + grid[i-1][j-1];
                y[i][j] = y[i-1][j] + grid[i-1][j-1];
            }
        }
        int ans = 0;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                for(int l = Math.min(i, j); l >= 1; l--) {
                    int sum = 0;
                    sum += x[i][j] - x[i][j-l];
                    sum += x[i-l+1][j] - x[i-l+1][j-l];
                    sum += y[i][j] - y[i-l][j];
                    sum += y[i][j-l+1] - y[i-l][j-l+1];
                    if(sum == 4*l)
                        ans = Math.max(ans, l*l);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Problem1139_Largest1BorderedSquare problem1139_largest_1Bordered_square = new Problem1139_Largest1BorderedSquare();
        System.out.println(problem1139_largest_1Bordered_square.largest1BorderedSquare(new int[][]{     // 9
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        }));
        System.out.println(problem1139_largest_1Bordered_square.largest1BorderedSquare(new int[][]{     // 1
                new int[]{1, 1, 0, 0}
        }));
        System.out.println(problem1139_largest_1Bordered_square.largest1BorderedSquare(new int[][]{     // 1
                new int[]{0, 0},
                new int[]{1, 0}
        }));
        System.out.println(problem1139_largest_1Bordered_square.largest1BorderedSquare(new int[][]{     // 1
                new int[]{0, 1},
                new int[]{1, 1}
        }));
    }
}
