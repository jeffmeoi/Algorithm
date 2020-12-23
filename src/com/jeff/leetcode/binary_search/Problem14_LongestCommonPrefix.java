package com.jeff.leetcode.binary_search;

public class Problem14_LongestCommonPrefix {

    public boolean isPrefix(String prefix, String[] strs) {
        for(String str : strs)
            if(!str.startsWith(prefix))
                return false;
        return true;
    }

    public int binarySearch(int start, int end, String[] strs){
        int mid = (start + end) / 2;
        if(end - start <= 1) {
            if(isPrefix(strs[0].substring(0, end), strs))
                return end;
            return start;
        }
        if(isPrefix(strs[0].substring(0, mid), strs))
            return binarySearch(mid, end, strs);
        return binarySearch(start, mid-1, strs);
    }



    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int min = strs[0].length();
        for(String str : strs)
            if(str.length() < min)
                min = str.length();
        return strs[0].substring(0, binarySearch(0, min, strs));
    }

    public static void main(String[] args) {
        Problem14_LongestCommonPrefix problem14_longestCommonPrefix = new Problem14_LongestCommonPrefix();
        System.out.println(problem14_longestCommonPrefix.longestCommonPrefix(new String[]{    // "fl"
                "flower", "flow", "flight"
        }));
        System.out.println(problem14_longestCommonPrefix.longestCommonPrefix(new String[]{    // ""
                "dog", "racecar", "car"
        }));
        System.out.println(problem14_longestCommonPrefix.longestCommonPrefix(new String[]{      // "a"
                "a"
        }));
    }
}
