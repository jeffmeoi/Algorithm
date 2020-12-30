package com.jeff.leetcode.simulation;

public class Problem121_BestTimeToBuyAndSellStock {


    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int res = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem121_BestTimeToBuyAndSellStock p = new Problem121_BestTimeToBuyAndSellStock();
        System.out.println(p.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));      // 5
        System.out.println(p.maxProfit(new int[] {7, 6, 4, 3, 1}));         // 0
    }
}
