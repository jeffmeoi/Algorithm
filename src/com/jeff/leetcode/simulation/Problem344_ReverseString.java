package com.jeff.leetcode.simulation;

public class Problem344_ReverseString {

    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public void reverseString(char[] s) {
        int mid = s.length/2;
        for(int i = 0; i < mid; i++)
            swap(s, i, s.length - 1 - i);
    }
}
