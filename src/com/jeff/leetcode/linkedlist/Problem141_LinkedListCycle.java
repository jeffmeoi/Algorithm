package com.jeff.leetcode.linkedlist;

import com.jeff.leetcode.structrue.ListNode;

public class Problem141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if(fastPtr == null)
                return false;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
            if(fastPtr != null && fastPtr == slowPtr)
                return true;
        }
        return false;
    }
}
