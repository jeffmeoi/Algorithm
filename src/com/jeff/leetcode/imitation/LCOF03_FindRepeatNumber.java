package com.jeff.leetcode.imitation;

public class LCOF03_FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > 1)
                return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        LCOF03_FindRepeatNumber p = new LCOF03_FindRepeatNumber();
        System.out.println(p.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));     // 2或3
    }

}
