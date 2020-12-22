package com.jeff.leetcode.simulation;

public class Problem8_String2Integer {

    public int myAtoi(String s) {
        boolean minus = false;
        long res = 0;
        int current = 0;
        s = s.trim();
        if(s.length() == 0)
            return 0;
        if (s.charAt(current) == '+') {
            current++;
        } else if (s.charAt(current) == '-') {
            minus = true;
            current++;
        }
        while (current < s.length() && Character.isDigit(s.charAt(current))) {
            int digit = s.charAt(current++) - '0';
            res = res * 10 + digit;
            if(res < 0 || res > Integer.MAX_VALUE) {
                res = ((long)Integer.MAX_VALUE)+1;
                break;
            }
        }
        if(minus)
            res = -res;
        if(res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) res;
    }

    public static void main(String[] args) {
        Problem8_String2Integer problem8_string2Integer = new Problem8_String2Integer();
        System.out.println(problem8_string2Integer.myAtoi("42"));       // 42
        System.out.println(problem8_string2Integer.myAtoi("-42"));      // -42
        System.out.println(problem8_string2Integer.myAtoi("4193 with words"));      // 4193
        System.out.println(problem8_string2Integer.myAtoi("words and 987"));        // 0
        System.out.println(problem8_string2Integer.myAtoi("-91283472332"));         // int_min
        System.out.println(problem8_string2Integer.myAtoi("9223372036854775808"));         // int_max
        System.out.println(problem8_string2Integer.myAtoi("-91283472332"));         // int_min
    }
}
