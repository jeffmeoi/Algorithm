package com.jeff.leetcode.two_pointers;

/**
 * 从右上角开始判断，
 * - 如果num==target，true
 * - 如果num>target，则num所在的一行的左边所有元素都不可能等于target，由于处于右上角，则说明一整行都不可能等于target，因此排除该行，变成(n-1,m)的矩阵继续判断
 * - 如果num<target，则num所在的一列的下边所有元素都不可能等于target，由于处于右上角，则说明一整列都不可能等于target，因此排除该行，变成(n,m-1)的矩阵继续判断
 * 不断地缩小搜索矩阵，就能得出搜索结果。
 * 时间复杂度为O(m+n)，空间复杂度为O(1)
 */
public class LCOF04_FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m =  matrix[0].length;
        int y = 0, x = m-1;
        while(y < n && x >= 0) {
            int num = matrix[y][x];
            if(num == target)
                return true;
            else if(num > target)
                x--;
            else
                y++;
        }
        return false;
    }
}
