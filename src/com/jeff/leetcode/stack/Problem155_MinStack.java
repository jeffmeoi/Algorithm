package com.jeff.leetcode.stack;

import java.util.LinkedList;

public class Problem155_MinStack {
    class MinStack {

        private LinkedList<Integer> stack = new LinkedList<>();
        private LinkedList<Integer> minStack = new LinkedList<>();

        /** initialize your data structure here. */
        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
