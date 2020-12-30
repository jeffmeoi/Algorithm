package com.jeff.leetcode.linkedlist;

import com.jeff.leetcode.structrue.ListNode;

public class Problem237_DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
