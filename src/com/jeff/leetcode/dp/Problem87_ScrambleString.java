package com.jeff.leetcode.dp;

/**
 * 逆向思考问题，把分割变为合并；
 * dp[a,b,c,d]记录串[a,b]是否能够通过分割/交换得到[c,d]
 * [a,b]要能变换为[c,d]，长度一定相同
 * 将四维变为三维，记录为dp[l,i,j],表示长度为l且s1中以i起始且s2中以j起始的字符串是否能够变换
 */
public class Problem87_ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int n = s1.length();
        char[] ascii = new char[255];
        for(int i = 0; i < n; i++) {
            ascii[s1.charAt(i)]++;
            ascii[s2.charAt(i)]--;
        }
        for(int i = 'a'; i <= 'z'; i++)
            if(ascii[i] != 0)
                return false;
        boolean[][][] dp = new boolean[n+1][n][n];
        for(int l = 1; l <= n; l++) {
            for(int i = 0; i + l <= n; i++) {
                for(int j = 0; j + l <= n; j++) {
                    if(l == 1) {
                        dp[l][i][j] = s1.charAt(i) == s2.charAt(j);
                    }else {
                        for (int k = 1; k < l; k++) {
                            dp[l][i][j] |= (dp[k][i][j] && dp[l - k][i + k][j + k]) || ((dp[k][i][j + l - k] && dp[l - k][i + k][j]));
                            if (dp[l][i][j])
                                break;
                        }
                    }
                }
            }
        }
        return dp[n][0][0];
    }

    public static void main(String[] args) {

        Problem87_ScrambleString problem = new Problem87_ScrambleString();
        System.out.println(problem.isScramble("great", "graet"));       // true
        System.out.println(problem.isScramble("abcde", "caebd"));       // false

    }

}
