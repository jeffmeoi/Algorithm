package com.jeff.leetcode.greedy;

public class Problem122_BestTimeToBuyAndSellStockII {


    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem122_BestTimeToBuyAndSellStockII p = new Problem122_BestTimeToBuyAndSellStockII();
        System.out.println(p.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));      // 7
        System.out.println(p.maxProfit(new int[] {1, 2, 3, 4, 5}));         // 4
        System.out.println(p.maxProfit(new int[] {7, 6, 4, 3, 1}));         // 0
    }
}
