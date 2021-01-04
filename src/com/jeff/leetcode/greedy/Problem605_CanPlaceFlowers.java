package com.jeff.leetcode.greedy;

public class Problem605_CanPlaceFlowers {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int range = 0;
        int cnt = 0;
        if(flowerbed[0] == 0)
            range++;
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                range++;
            }
            if(flowerbed[i] == 1 || i == flowerbed.length - 1) {
                if(flowerbed[i] == 1)
                    range--;
                if(range > 0)
                    cnt += range/2;
                range = 0;
            }
        }
        return cnt >= n;
    }

    public static void main(String[] args) {
        Problem605_CanPlaceFlowers p = new Problem605_CanPlaceFlowers();
        System.out.println(p.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));     // t
        System.out.println(p.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));     // t
        System.out.println(p.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));     // f
        System.out.println(p.canPlaceFlowers(new int[]{0,0,1,0,0,0,1,0,0,0}, 2));     // t
        System.out.println(p.canPlaceFlowers(new int[]{0,0,0,0,1,0,0,0,1,0,0,0,0,0}, 2));     // t
    }
}
