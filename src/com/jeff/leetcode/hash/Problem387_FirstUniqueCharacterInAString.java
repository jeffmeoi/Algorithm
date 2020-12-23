package com.jeff.leetcode.hash;

public class Problem387_FirstUniqueCharacterInAString {


    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[255];
        for (char ch : chars) cnt[ch]++;
        for(int i = 0; i < chars.length; i++)
            if(cnt[chars[i]] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Problem387_FirstUniqueCharacterInAString problem387_firstUniqueCharacterInAString = new Problem387_FirstUniqueCharacterInAString();
        System.out.println(problem387_firstUniqueCharacterInAString.firstUniqChar("leetcode"));     // 0
        System.out.println(problem387_firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));     // 2
    }
}
