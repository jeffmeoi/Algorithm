package com.jeff.leetcode.imitation;

public class Problem557_ReverseWordsInAStringIII {

    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public String reverseString(String str) {
        char[] s = str.toCharArray();
        int mid = s.length/2;
        for(int i = 0; i < mid; i++)
            swap(s, i, s.length - 1 - i);
        return new String(s);
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if(words.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length - 1; i++)
            sb.append(reverseString(words[i])).append(" ");
        sb.append(reverseString(words[words.length - 1]));
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem557_ReverseWordsInAStringIII p = new Problem557_ReverseWordsInAStringIII();
        System.out.println(p.reverseWords("Let's take LeetCode contest"));      // s'teL ekat edoCteeL tsetnoc
    }
}
