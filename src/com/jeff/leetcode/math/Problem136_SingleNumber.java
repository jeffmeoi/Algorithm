package com.jeff.leetcode.math;

public class Problem136_SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }

    public static void main(String[] args) {
        Problem136_SingleNumber p = new Problem136_SingleNumber();
        System.out.println(p.singleNumber(new int[] {2, 2, 1}));        // 1
        System.out.println(p.singleNumber(new int[] {4, 1, 2, 1, 2}));        // 4
    }
}
