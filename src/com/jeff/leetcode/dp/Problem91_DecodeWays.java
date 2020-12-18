package com.jeff.leetcode.dp;

/**
 * dp[i]表示s[0-i]的最大编码数
 * 每次根据最后2个字符做转移
 */
public class Problem91_DecodeWays {

    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i <= s.length(); i++) {
            char lastOneChar = s.charAt(i - 1);
            char lastTwoChar = 0;
            if(i >= 2)
                lastTwoChar = s.charAt(i - 2);
            int code1 = lastOneChar - '0';
            int code2 = (lastTwoChar - '0') * 10 + code1;
            if(code1 == 0) {
                if(code2 >= 10 && code2 <= 26)
                    dp[i] = dp[i-2];
                else return 0;
            } else if(10 <= code2 && code2 <= 26){
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Problem91_DecodeWays problem = new Problem91_DecodeWays();
        System.out.println(problem.numDecodings("12"));     // 2
        System.out.println(problem.numDecodings("226"));    // 3
        System.out.println(problem.numDecodings("0"));      // 0
        System.out.println(problem.numDecodings("1"));      // 1
        System.out.println(problem.numDecodings("2101"));      // 1
        System.out.println(problem.numDecodings("10011"));      // 0
        System.out.println(problem.numDecodings("27"));      // 1
        System.out.println(problem.numDecodings("230"));      // 0
    }
}
