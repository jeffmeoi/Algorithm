package com.jeff.leetcode.dp;

import java.util.Arrays;

/**
 * 思路：以每个点为基本单位，找出包含某个点在内的面积最大的矩形
 * 要求面积最大的矩形，需要知道该矩形的宽和高
 * 经过推理可知，必然存在一个下边界上的点拥有与最大的矩形相同的高度，且在具有该高度的情况下具有相同的左边界、右边界
 * 因此只要遍历每个点作为下界，就能得到所有矩形的上边界、左边界、右边界信息
 * 于是得到上边界、下边界、左边界、右边界的信息，于是由上边界和下边界得到高，由左边界和右边界得出宽
 *
 * 通过上一行的某个点边界信息，可以通过递推得到该行对应点的边界信息
 * 因此该题需要对每一行的边界信息(height,left,right)做dp
 *
 */
public class Problem85_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 0);
        Arrays.fill(right, n-1);

        int maxArea = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            int curLeft = 0, curRight = n - 1;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1')
                    left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for(int j = n-1; j >= 0; j--) {
                if(matrix[i][j] == '1')
                    right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n - 1;
                    curRight = j - 1;
                }
            }
            for(int j = 0; j < n; j++)
                maxArea = Math.max(maxArea, (right[j] - left[j]+1)*height[j]);
        }
        return maxArea;
    }

    public static void main(String[] args) {

        Problem85_MaximalRectangle problem = new Problem85_MaximalRectangle();
        System.out.println(problem.maximalRectangle(new char[][]{       // 6
                new char[]{'1', '0', '1', '0', '0'},
                new char[]{'1', '0', '1', '1', '1'},
                new char[]{'1', '1', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '0'}
        }));
        System.out.println(problem.maximalRectangle(new char[][]{
                new char[]{}
        }));   // 0
        System.out.println(problem.maximalRectangle(new char[][]{       // 0
                new char[]{'0'}
        }));
        System.out.println(problem.maximalRectangle(new char[][]{       // 1
                new char[]{'1'}
        }));
        System.out.println(problem.maximalRectangle(new char[][]{       // 0
                new char[]{'0', '0'}
        }));
    }
}
