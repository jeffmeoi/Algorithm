package com.jeff.leetcode.simulation;

public class Problem26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0)
            return 0;
        int cnt = 1;
        for(int i = 1; i < nums.length; i++)
            if(nums[i] != nums[i-1]) {
                cnt++;
            } else {
                nums[i-1] = Integer.MAX_VALUE;
            }
        int current = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != Integer.MAX_VALUE)
                nums[current++] = nums[i];
        return cnt;
    }

    public static void main(String[] args) {
        Problem26_RemoveDuplicatesFromSortedArray problem26_removeDuplicatesFromSortedArray = new Problem26_RemoveDuplicatesFromSortedArray();
        System.out.println(problem26_removeDuplicatesFromSortedArray.removeDuplicates(new int[]{1, 1, 2}));             // 2
        System.out.println(problem26_removeDuplicatesFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})); // 5
    }
}
