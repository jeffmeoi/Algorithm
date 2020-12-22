package com.jeff.leetcode.math;

public class Problem7_ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        boolean sign = x < 0;
        x = Math.abs(x);
        while(x != 0) {
            res = 10 * res + (x % 10);
            x /= 10;
        }
        if(sign)
            res = -res;
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int)res;
    }

    public static void main(String[] args) {
        Problem7_ReverseInteger problem7_reverseInteger = new Problem7_ReverseInteger();
        System.out.println(problem7_reverseInteger.reverse(321));       // 123
        System.out.println(problem7_reverseInteger.reverse(-123));      // -321
        System.out.println(problem7_reverseInteger.reverse(120));       // 21
    }
}
