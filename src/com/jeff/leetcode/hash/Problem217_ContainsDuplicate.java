package com.jeff.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class Problem217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            if(!set.add(num))
                return true;
        return false;
    }

    public static void main(String[] args) {
        Problem217_ContainsDuplicate p = new Problem217_ContainsDuplicate();
        System.out.println(p.containsDuplicate(new int[]{1,2,3,1}));                // t
        System.out.println(p.containsDuplicate(new int[]{1,2,3,4}));                // f
        System.out.println(p.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));    // t
    }
}
