package com.jeff.leetcode.linkedlist;

import com.jeff.leetcode.structrue.ListNode;

public class Problem160_IntersectionOfTwoLinkedLists {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tail = headA;
        while (tail.next != null)
            tail = tail.next;
        tail.next = headB;
        ListNode fastPtr = headA;
        ListNode slowPtr = headA;
        ListNode res = null;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            if(fastPtr == null)
                break;
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
            if(fastPtr != null && fastPtr == slowPtr) {
                ListNode thirdPtr = headA;
                while (slowPtr != thirdPtr) {
                    slowPtr = slowPtr.next;
                    thirdPtr = thirdPtr.next;
                }
                res = slowPtr;
                break;
            }
        }
        tail.next = null;
        return res;
    }
}
