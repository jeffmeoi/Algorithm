package com.jeff.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class Problem78_Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        int cnt = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < cnt; i++) {
            List<Integer> collection = new ArrayList<>();
            for(int j = 0; j < nums.length; j++) {
                if((i & (1<<j)) != 0) {
                    collection.add(nums[j]);
                }
            }
            res.add(collection);
        }
        return res;
    }

    public static void main(String[] args) {

        Problem78_Subsets problem78_subsets = new Problem78_Subsets();
        System.out.println(problem78_subsets.subsets(new int[]{1, 2, 3}));
    }
}
