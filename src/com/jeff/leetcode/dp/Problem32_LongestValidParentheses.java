package com.jeff.leetcode.dp;


/**
 * dp[i] 表示s[0]-s[i]内以s[i]结尾的最长的有效括号子串的长度
 * 每个有效括号子串可能由多个有效括号子串组成
 * 最后两个字符只有((/()/))/)(四种情况
 * 若最后一个字符为(即((/)(，则最后一个字符必不与前面的字符相匹配；
 * 考虑))/()两种情况
 * ()情况最后两个字符相互匹配，则直接dp[i]=dp[i-2]+2
 * ))情况最后两个字符不相互匹配，则最后一个)去与前一个有效括号子串的左一个字符去匹配，如果匹配，则与前面的有效括号子串相连，如果不匹配，则说明序列断开
 */
public class Problem32_LongestValidParentheses {


    public int longestValidParentheses(String s) {
        int max = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i+=1) {
            if(s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(')
                    dp[i] = (i>=2 ? dp[i - 2] : 0) + 2;
                else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    int pre = (i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i - 1] + pre + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem32_LongestValidParentheses problem = new Problem32_LongestValidParentheses();
        System.out.println(problem.longestValidParentheses(""));        // 0
        System.out.println(problem.longestValidParentheses("()"));      // 2
    }
}
