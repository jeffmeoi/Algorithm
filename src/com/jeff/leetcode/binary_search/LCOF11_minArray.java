package com.jeff.leetcode.binary_search;

public class LCOF11_minArray {

    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int mid = (l+r)/2;
            if(numbers[mid] < numbers[r]) {
                r = mid;
            } else if(numbers[mid] > numbers[r]) {
                l = mid+1;
            } else {
                r--;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        LCOF11_minArray p = new LCOF11_minArray();
        System.out.println(p.minArray(new int[]{3,4,5,1,2}));       // 1
        System.out.println(p.minArray(new int[]{2,2,2,0,1}));       // 0
    }
}
