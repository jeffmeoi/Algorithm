package com.jeff.leetcode.simulation;

public class Problem9_PalindromeNumber {


//    public boolean isPalindrome(int x) {
//        if(x < 0)
//            return false;
//        int[] arr = new int[32];
//        int current = 0;
//        while (x != 0) {
//            arr[current++] = x % 10;
//            x /= 10;
//        }
//        for(int i = 0; i < current; i++)
//            if(arr[i] != arr[current - i - 1])
//                return false;
//        return true;
//    }

    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int val = x;
        int num = 0;
        while(val != 0) {
            num = num * 10 + (val % 10);
            val /= 10;
        }
        return num == x;
    }

    public static void main(String[] args) {
        Problem9_PalindromeNumber problem9_palindromeNumber = new Problem9_PalindromeNumber();
        System.out.println(problem9_palindromeNumber.isPalindrome(121));        // t
        System.out.println(problem9_palindromeNumber.isPalindrome(-121));       // f
        System.out.println(problem9_palindromeNumber.isPalindrome(10));         // f
    }
}
