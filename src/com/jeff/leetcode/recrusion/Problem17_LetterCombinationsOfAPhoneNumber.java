package com.jeff.leetcode.recrusion;

import java.util.ArrayList;
import java.util.List;

public class Problem17_LetterCombinationsOfAPhoneNumber {

    private String[] arr = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public void recursion(String digits, int index, StringBuilder sb, List<String> res) {
        if(index >= digits.length()) {
            if(sb.length() > 0)
                res.add(sb.toString());
            return;
        }
        int offset =  digits.charAt(index) - '0';
        for(char i = 0; i < arr[offset].length(); i++) {
            sb.append(arr[offset].charAt(i));
            recursion(digits, index+1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        recursion(digits, 0, new StringBuilder(), res);
        return res;
    }

    public static void main(String[] args) {
        Problem17_LetterCombinationsOfAPhoneNumber problem17_letterCombinationsOfAPhoneNumber = new Problem17_LetterCombinationsOfAPhoneNumber();
        System.out.println(problem17_letterCombinationsOfAPhoneNumber.letterCombinations("23"));
        System.out.println(problem17_letterCombinationsOfAPhoneNumber.letterCombinations("93"));
        System.out.println(problem17_letterCombinationsOfAPhoneNumber.letterCombinations(""));
    }

}
