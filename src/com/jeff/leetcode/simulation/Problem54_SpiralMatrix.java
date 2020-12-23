package com.jeff.leetcode.simulation;

import java.util.ArrayList;
import java.util.List;

public class Problem54_SpiralMatrix {


    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<>();

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();

        int direct = 0;
        int posX = 0, posY = 0;
        int cnt = 1;
        vis[0][0] = true;
        res.add(matrix[0][0]);

        while (cnt < matrix.length * matrix[0].length) {
            while (true){
                int y = posY+dy[direct], x = posX+dx[direct];
                if(y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length && !vis[y][x]){
                    res.add(matrix[y][x]);
                    vis[y][x] = true;
                    posX = x;
                    posY = y;
                    cnt++;
                    break;
                } else {
                    direct = (direct + 1) % 4;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Problem54_SpiralMatrix problem54_spiralMatrix = new Problem54_SpiralMatrix();
        System.out.println(problem54_spiralMatrix.spiralOrder(new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        }));
        System.out.println(problem54_spiralMatrix.spiralOrder(new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12}
        }));
        System.out.println(problem54_spiralMatrix.spiralOrder(new int[][]{
                new int[]{1,2,3,4},
        }));
        System.out.println(problem54_spiralMatrix.spiralOrder(new int[][]{
                new int[]{},
        }));

    }
}
