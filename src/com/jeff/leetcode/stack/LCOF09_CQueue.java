package com.jeff.leetcode.stack;

import java.util.LinkedList;

public class LCOF09_CQueue {

    private LinkedList<Integer> s1 = new LinkedList<>();
    private LinkedList<Integer> s2 = new LinkedList<>();

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()){
            int n = s1.size();
            for(int i = 0; i < n; i++)
                s2.push(s1.pop());
        }
        if(!s2.isEmpty())
            return s2.pop();
        return -1;
    }

}
