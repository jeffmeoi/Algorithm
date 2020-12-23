package com.jeff.leetcode.math;

public class Problem43_MultiplyStrings {


    public String multiply(String num1, String num2) {
        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];
        int[] res = new int[num1.length() + num2.length() + 1];

        for(int i = 0; i < num1.length(); i++)
            arr1[i] = num1.charAt(num1.length() - i - 1) - '0';
        for(int i = 0; i < num2.length(); i++)
            arr2[i] = num2.charAt(num2.length() - i - 1) - '0';

        for(int i = 0; i < num1.length(); i++)
            for(int j = 0; j < num2.length(); j++)
                res[i+j] += arr1[i] * arr2[j];

        for(int i = 0; i < res.length - 1; i++) {
            res[i + 1] += res[i] / 10;
            res[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int first = res.length - 1;
        while(first > 0 && res[first] == 0)
            first--;
        for(int i = first; i >= 0; i-- )
            sb.append((char)(res[i] + '0'));
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem43_MultiplyStrings problem43_multiplyStrings = new Problem43_MultiplyStrings();
        System.out.println(problem43_multiplyStrings.multiply("2", "3"));   // 6
        System.out.println(problem43_multiplyStrings.multiply("123", "456"));   // 56088
        System.out.println(problem43_multiplyStrings.multiply("0", "0"));   // 0
    }
}
