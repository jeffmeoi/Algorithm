package com.jeff.leetcode.linkedlist;

import java.util.PriorityQueue;

public class Problem23_MergeKSortedLists {


//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = new ListNode(0, null), tail = head;
//        int cnt = 0;
//        while (cnt < lists.length) {
//            int minIndex = 0;
//            for (int i = 0; i < lists.length; i++)
//                if(lists[i] != null && (lists[minIndex]==null? Integer.MAX_VALUE:lists[minIndex].val) > lists[i].val)
//                    minIndex = i;
//            if(lists[minIndex] == null)
//                break;
//            ListNode node = new ListNode(lists[minIndex].val, null);
//            tail.next = node;
//            tail = node;
//            lists[minIndex] = lists[minIndex].next;
//            if(lists[minIndex] == null)
//                cnt++;
//        }
//        return head.next;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++)
            while (lists[i] != null){
                queue.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        ListNode head = new ListNode(0, null), tail = head;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll(), null);
            tail.next = node;
            tail = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Problem23_MergeKSortedLists problem23_mergeKSortedLists = new Problem23_MergeKSortedLists();
        System.out.println(problem23_mergeKSortedLists.mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        }));
        System.out.println(problem23_mergeKSortedLists.mergeKLists(new ListNode[]{}));
        System.out.println(problem23_mergeKSortedLists.mergeKLists(new ListNode[]{new ListNode()}));
    }
}
