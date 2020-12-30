package com.jeff.leetcode.linkedlist;


public class Problem21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null), tail = head;
        while (l1 != null || l2 != null) {
            ListNode node;
            if (l2 == null || l1 != null && l1.val < l2.val) {
                node = new ListNode(l1.val, null);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val, null);
                l2 = l2.next;
            }
            tail.next = node;
            tail = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Problem21_MergeTwoSortedLists problem21_mergeTwoSortedLists = new Problem21_MergeTwoSortedLists();
        ListNode l1 = new ListNode(4, null);
        l1 = new ListNode(2, l1);
        l1 = new ListNode(1, l1);
        ListNode l2 = new ListNode(4, null);
        l2 = new ListNode(3, l2);
        l2 = new ListNode(1, l2);
        System.out.println(problem21_mergeTwoSortedLists.mergeTwoLists(l1, l2));
    }
}
