package com.jeff.leetcode.dp;

/**
 * 最长回文子串
 * dp[i][j] means the string between i(inclusive) and j(inclusive) is palindrome substring
 * dp[i][j] = true, if i == j or
 * dp[i][j] = true, if j == i + 1 && s[i] == s[j] or
 * dp[i][j] = true, if j - i > 1 && dp[i+1][j-1] == true && s[i] == s[j]
 */
class Problem5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        String res = "";
        
        for(int l = 0; l < len; l++) {
            for(int i = 0; i + l < len; i++) {
                int j = i + l;
                if(l == 0)
                    dp[i][j] = true;
                else if(l == 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else 
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);;
                if(dp[i][j] && j - i + 1 > res.length())
                    res = s.substring(i, j+1);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Problem5_LongestPalindromicSubstring problem5 = new Problem5_LongestPalindromicSubstring();
        System.out.println(problem5.longestPalindrome("aaaaa"));            // aaaaa
    }
}