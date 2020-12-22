package com.jeff.leetcode.linkedlist;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Problem2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, end = null;
        int CO = 0;
        while(l1 != null || l2 != null || CO != 0){
            int num = CO;
            if(l1 != null)
                num += l1.val;
            if(l2 != null)
                num += l2.val;
            ListNode newNode = new ListNode(num % 10);
            if(end == null)
                end = newNode;
            else{
                end.next = newNode;
                end = end.next;
            }
            if(head == null)
                head = newNode;
            CO = num / 10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return head;
    }


}
