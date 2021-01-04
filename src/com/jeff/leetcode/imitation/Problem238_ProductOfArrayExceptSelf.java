package com.jeff.leetcode.imitation;

import java.util.Arrays;

public class Problem238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0)
            return new int[]{};
        int[] res = new int[nums.length];
        int suffix = 1;
        res[0] = 1;
        for(int i = 1; i < nums.length; i++)
            res[i] = res[i-1]*nums[i-1];
        for(int i = nums.length - 1; i >= 0 ; i--) {
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Problem238_ProductOfArrayExceptSelf p = new Problem238_ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4})));     // [24,12,8,6]
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{2, 2, 3, 4})));     // [24,23,16,12]
    }
}
