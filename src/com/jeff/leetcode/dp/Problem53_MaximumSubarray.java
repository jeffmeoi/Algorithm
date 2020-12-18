package com.jeff.leetcode.dp;

/**
 * dp[i]表示以dp[i]结尾的最大子序和
 */
public class Problem53_MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem53_MaximumSubarray problem53 = new Problem53_MaximumSubarray();
        System.out.println(problem53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));        // 6
    }

}
