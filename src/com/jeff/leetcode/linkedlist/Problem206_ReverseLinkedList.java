package com.jeff.leetcode.linkedlist;

import com.jeff.leetcode.structrue.ListNode;

public class Problem206_ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        ListNode ptr = head;
        ListNode res = null;
        while (ptr != null) {
            ListNode node = new ListNode(ptr.val);
            node.next = res;
            res = node;
            ptr = ptr.next;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem206_ReverseLinkedList p = new Problem206_ReverseLinkedList();
        System.out.println(p.reverseList(new ListNode(1, new ListNode( 2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
        System.out.println(p.reverseList(null));
    }
}
