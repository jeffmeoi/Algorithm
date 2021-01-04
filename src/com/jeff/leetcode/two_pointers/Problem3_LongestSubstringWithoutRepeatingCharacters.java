package com.jeff.leetcode.double_pointer;

import java.util.Arrays;

public class Problem3_LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        int cnt = 0;
        if(s.length() == 0)
            return 0;
        int[] last = new int[255];
        Arrays.fill(last, -1);
        int l = -1;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            l = Math.max(l, last[c]);
            last[c] = r;
            cnt = Math.max(cnt, r-l);
        }
        return cnt;
    }

    public static void main(String[] args) {
        Problem3_LongestSubstringWithoutRepeatingCharacters p = new Problem3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(p.lengthOfLongestSubstring(" "));     // 1
        System.out.println(p.lengthOfLongestSubstring("abcabcbb"));     // 3
        System.out.println(p.lengthOfLongestSubstring("bbbbb"));        // 1
        System.out.println(p.lengthOfLongestSubstring("pwwkew"));       // 3
        System.out.println(p.lengthOfLongestSubstring(""));             // 0
    }
}
