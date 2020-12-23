package com.jeff.leetcode.double_pointer;

import java.util.*;

public class Problem15_3Sum {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int pointer3 = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if(j != i + 1 && nums[j] == nums[j-1])
                    continue;
                int num3 = -(nums[i] + nums[j]);
                while(pointer3 >= 0 && nums[pointer3] > num3)
                    pointer3--;
                if(pointer3 <= j)
                    break;
                if(num3 == nums[pointer3])
                    res.add(Arrays.asList(nums[i], nums[j], num3));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem15_3Sum problem15_3Sum = new Problem15_3Sum();
        System.out.println(problem15_3Sum.threeSum(new int[] {
                -1, 0, 1, 2, -1, -4
        }));
        System.out.println(problem15_3Sum.threeSum(new int[] {
                1, 1
        }));
    }
}
