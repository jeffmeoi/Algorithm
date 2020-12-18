package com.jeff.leetcode.dp;

/**
 * dp[i][j] means s[0]-s[i-1] match p[0]-p[j-1]
 * dp[i][j] = true if dp[i-1][j-1] == true && s[i-1] match p[j-1]
 * dp[i][j] = dp[i-1][j] || dp[i][j-2] , if s[i-1] match p[j-2] && p[j-1] = *
 * dp[i][j] = dp[i][j-2] , if s[i-1] not match p[j-2] && p[j-1] = *
 */
public class Problem10_RegularExpressionMatching {

    private boolean isMatch(char ch, char p){
        return p == '.' || ch == p;
    }

    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];

        dp[0][0] = true;

        for(int i = 0; i <= s.length(); i++) {
            for(int j = 0; j <= p.length(); j++) {
                if(j>=1 && p.charAt(j-1) == '*') {
                    if(i>= 1 && j>= 2 && isMatch(s.charAt(i-1), p.charAt(j-2))) {
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                } else {
                    if(i>=1 && j>=1 && isMatch(s.charAt(i-1), p.charAt(j-1)))
                        dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Problem10_RegularExpressionMatching problem = new Problem10_RegularExpressionMatching();
        System.out.println(problem.isMatch("aa", "a"));                     // false
        System.out.println(problem.isMatch("aa", "a*"));                    // true
        System.out.println(problem.isMatch("ab", ".*"));                    // true
        System.out.println(problem.isMatch("aab", "c*a*b"));                // true
        System.out.println(problem.isMatch("mississippi", "mis*is*p*."));   // false
        System.out.println(problem.isMatch("mississippi", "mis*is*ip*."));  // true
    }
}
