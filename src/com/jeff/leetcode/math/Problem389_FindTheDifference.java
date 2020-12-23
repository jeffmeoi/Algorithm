package com.jeff.leetcode.math;

public class Problem389_FindTheDifference {

    public char findTheDifference(String s, String t) {
        int ans = 0;
        for(int i = 0; i < t.length(); i++)
            ans ^= t.charAt(i);
        for (int i = 0; i < s.length(); i++)
            ans ^= s.charAt(i);
        return (char) ans;
    }

    public static void main(String[] args) {
        Problem389_FindTheDifference problem389_findTheDifference = new Problem389_FindTheDifference();
        System.out.println(problem389_findTheDifference.findTheDifference("abcd", "abcde"));    // e
        System.out.println(problem389_findTheDifference.findTheDifference("", "y"));            // y
        System.out.println(problem389_findTheDifference.findTheDifference("a", "aa"));          // a
        System.out.println(problem389_findTheDifference.findTheDifference("ae", "aea"));        // a
    }
}
