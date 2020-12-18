package com.jeff.leetcode.dp;

/**
 * if p[j]=*, dp[i][j]=dp[i-1][j]
 * if s[i]=p[j] || p[j]==?, dp[i][j]=dp[i-1][j-1]
 */
public class Problem44_WildcardMatching {


    public boolean isMatch(String s, String p) {
        s = " " + s;
        p = " " + p;
        boolean dp[][] = new boolean[s.length()][p.length()];
        dp[0][0] = true;
        for(int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '*')
                    dp[i][j] = (i>=1 ? dp[i-1][j] : false) || (j>=1 ? dp[i][j-1] : false);
                else if(i>=1 && j>=1 && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)))
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[s.length()-1][p.length()-1];
    }

    public static void main(String[] args) {
        Problem44_WildcardMatching problem44 = new Problem44_WildcardMatching();
//        System.out.println(problem44.isMatch("aa", "a"));           // false
        System.out.println(problem44.isMatch("aa", "*"));           // true
        System.out.println(problem44.isMatch("cb", "?a"));          // false
        System.out.println(problem44.isMatch("adceb", "*a*b"));     // true
        System.out.println(problem44.isMatch("acdcb", "a*c?b"));    // false
    }


}
