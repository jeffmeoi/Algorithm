package com.jeff.leetcode;


public class Problem59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        if(n == 0)
            return new int[0][0];

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int[][] matrix = new int[n][n];
        int cnt = 1;
        int posX = 0, posY = 0;
        int direct = 0;
        matrix[0][0] = 1;
        while (cnt < n*n) {
            while (true){
                int y = posY+dy[direct], x = posX+dx[direct];
                if(y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length && 0 == matrix[y][x]){
                    matrix[y][x] = ++cnt;
                    posX = x;
                    posY = y;
                    break;
                } else {
                    direct = (direct + 1) % 4;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

        Problem59_SpiralMatrixII problem59_spiralMatrixII = new Problem59_SpiralMatrixII();
        int[][] mat = problem59_spiralMatrixII.generateMatrix(3);
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        mat = problem59_spiralMatrixII.generateMatrix(4);
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        mat = problem59_spiralMatrixII.generateMatrix(5);
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
