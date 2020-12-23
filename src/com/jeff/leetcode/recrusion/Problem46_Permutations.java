package com.jeff.leetcode.recrusion;

import java.util.*;

public class Problem46_Permutations {

    public void backtrace(List<Integer> nums, List<List<Integer>> res, int first) {
        if(first == nums.size()) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for(int i = first; i < nums.size(); i++) {
            Collections.swap(nums, first, i);
            backtrace(nums, res, first+1);
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        for(int num : nums)
            list.add(num);
        backtrace(list, res, 0);
        return res;
    }

    public static void main(String[] args) {
        Problem46_Permutations problem46_permutations = new Problem46_Permutations();
        System.out.println(problem46_permutations.permute(new int[]{1,2,3}));
    }
}
