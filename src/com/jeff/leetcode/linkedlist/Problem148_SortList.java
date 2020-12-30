package com.jeff.leetcode.linkedlist;

import com.jeff.leetcode.structrue.ListNode;

public class Problem148_SortList {


    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if(head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode mid = findMidNode(head, tail);
        ListNode left = sortList(head, mid);
        ListNode right = sortList(mid, tail);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        while(left != null && right != null) {
            if(left.val < right.val){
                ptr.next = left;
                left = left.next;
            } else {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }
        if (left != null) {
            ptr.next = left;
        } else {
            ptr.next = right;
        }
        return head.next;
    }

    public ListNode findMidNode(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Problem148_SortList p = new Problem148_SortList();
        System.out.println(p.sortList(new ListNode(4, null)));
        System.out.println(p.sortList(new ListNode(4, new ListNode(2))));
        System.out.println(p.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(7))))))));
    }
}
