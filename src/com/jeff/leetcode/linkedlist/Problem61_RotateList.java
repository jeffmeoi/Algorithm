package com.jeff.leetcode.linkedlist;

public class Problem61_RotateList {
    // Definition for singly-linked list.
    static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode kth = head;
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }
        if(len == 0)
            return head;
        k %= len;
        ptr = head;
        for(int i = 0; i < k; i++)
            kth = kth.next;
        while (kth.next != null) {
            kth = kth.next;
            ptr = ptr.next;
        }
        kth.next = head;
        head = ptr.next;
        ptr.next = null;
        return head;
    }

    public static void main(String[] args) {

        Problem61_RotateList problem61_rotateList = new Problem61_RotateList();
        System.out.println(problem61_rotateList.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(problem61_rotateList.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));
    }
}
