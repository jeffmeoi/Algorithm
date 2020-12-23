package com.jeff.leetcode.double_pointer;

import java.util.Arrays;

public class Problem16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int res = 10001;
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int pointer3 = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if(j != i + 1 && nums[j] == nums[j-1])
                    continue;
                if(pointer3 < j)
                    break;
                while(pointer3 > j && nums[i] + nums[j] + nums[pointer3] > target)
                    pointer3--;
                int sum1 = pointer3 > j ? nums[pointer3] + nums[i] + nums[j] : 10001;
                int sum2 = pointer3 + 1 > j && pointer3 + 1 < nums.length ? nums[pointer3+1] + nums[i] + nums[j] : 10001;
                if(Math.abs(sum1 - target) < Math.abs(sum2 - target)) {
                    res = Math.abs(res - target) < Math.abs(sum1 - target) ? res : sum1;
                } else {
                    res = Math.abs(res - target) < Math.abs(sum2 - target) ? res : sum2;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem16_3SumClosest problem15_3Sum = new Problem16_3SumClosest();
        System.out.println(problem15_3Sum.threeSumClosest(new int[] {
                1, 1, -1, -1, 3
        }, -1));
        System.out.println(problem15_3Sum.threeSumClosest(new int[] {
            0, 1, 2
        }, 0));
        System.out.println(problem15_3Sum.threeSumClosest(new int[] {
                -1, 2, 1, -4
        }, 1));
    }
}
