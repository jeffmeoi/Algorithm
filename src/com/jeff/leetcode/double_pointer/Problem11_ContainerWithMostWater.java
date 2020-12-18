package com.jeff.leetcode.double_pointer;

/**
 * left为左指针，right为右指针，每次选择比较小的数向内移动一步
 */
public class Problem11_ContainerWithMostWater {


    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        int left = 0, right = height.length - 1;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if ((height[left] < height[right])) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem11_ContainerWithMostWater problem = new Problem11_ContainerWithMostWater();
        System.out.println(problem.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));          // 49
        System.out.println(problem.maxArea(new int[]{1,1}));                        // 1
        System.out.println(problem.maxArea(new int[]{4,3,2,1,4}));                  // 16
        System.out.println(problem.maxArea(new int[]{1,2,1}));                      // 2
    }
}
