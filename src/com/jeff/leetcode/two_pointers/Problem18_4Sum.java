package com.jeff.leetcode.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] + nums[i] + nums[i+1] + nums[i+2] > target)
                break;
            if(nums[i] + nums[nums.length-3] + nums[nums.length-2] + nums[nums.length-1] < target)
                continue;
            for(int j = i + 1; j < nums.length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1])
                    continue;
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target)
                    break;
                if(nums[i] + nums[j] + nums[nums.length-2] + nums[nums.length-1] < target)
                    continue;
                int current = nums.length - 1;
                for(int k = j + 1; k < nums.length-1; k++) {
                    if(k > j+1 && nums[k] == nums[k-1])
                        continue;
                    if(nums[i] + nums[j] + nums[k] + nums[k+1]  > target)
                        break;
                    if(nums[i] + nums[j] + nums[k] + nums[nums.length-1] < target)
                        continue;
                    while(current > k && nums[i] + nums[j] + nums[k] + nums[current] > target)
                        current--;
                    if(current > k && nums[i] + nums[j] + nums[k] + nums[current] == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[current]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem18_4Sum problem18_4Sum = new Problem18_4Sum();
        System.out.println(problem18_4Sum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(problem18_4Sum.fourSum(new int[]{}, 0));
    }
}
