package com.jeff.leetcode.math;

/**
 * Boyer-Moore算法
 * cnt相当于，众数比非众数多的数量的绝对值
 */
public class Problem169_MajorityElement {


    public int majorityElement(int[] nums) {
        int candidate = 0;
        int cnt = 0;
        for (int num : nums) {
            if (cnt == 0)
                candidate = num;
            cnt += candidate == num ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        Problem169_MajorityElement p = new Problem169_MajorityElement();
        System.out.println(p.majorityElement(new int[]{3, 2, 3}));                 // 3
        System.out.println(p.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));     // 2
    }

}
