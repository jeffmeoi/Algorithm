package com.jeff.leetcode.stack;

import java.util.LinkedList;

public class Problem20_ValidParentheses {

    public boolean isValid(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '{':
                case '(':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else return false;
                    break;
                case ']':
                    if(!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else return false;
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Problem20_ValidParentheses problem20_validParentheses = new Problem20_ValidParentheses();
        System.out.println(problem20_validParentheses.isValid("()"));       // t
        System.out.println(problem20_validParentheses.isValid("()[]{}"));   // t
        System.out.println(problem20_validParentheses.isValid("(]"));   // f
        System.out.println(problem20_validParentheses.isValid("([)]"));   // f
        System.out.println(problem20_validParentheses.isValid("{[]}"));   // t

    }
}
