package com.jeff.leetcode.math;
public class Problem877_StoneGame {
    public boolean stoneGame(int[] piles) {
        return true;
    }

    public static void main(String[] args) {
        Problem877_StoneGame problem877_stoneGame = new Problem877_StoneGame();
        System.out.println(problem877_stoneGame.stoneGame(new int[]{ 5, 3, 4, 5 }));        // true
        System.out.println(problem877_stoneGame.stoneGame(new int[]{ 3, 7, 2, 3 }));        // true
        System.out.println(problem877_stoneGame.stoneGame(new int[]{ 3, 3 }));        // true
    }
}
