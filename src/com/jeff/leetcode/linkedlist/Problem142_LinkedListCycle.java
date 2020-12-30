package com.jeff.leetcode.linkedlist;

import com.jeff.leetcode.structrue.ListNode;

public class Problem142_LinkedListCycle {


    public ListNode detectCycle(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if(fastPtr == null)
                return null;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
            if(fastPtr != null && fastPtr == slowPtr) {
                ListNode thirdPtr = head;
                while (slowPtr != thirdPtr) {
                    slowPtr = slowPtr.next;
                    thirdPtr = thirdPtr.next;
                }
                return slowPtr;
            }
        }
        return null;
    }
}
