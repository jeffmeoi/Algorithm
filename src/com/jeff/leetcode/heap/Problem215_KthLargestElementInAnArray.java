package com.jeff.leetcode.heap;

import java.util.PriorityQueue;

public class Problem215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for(int num : nums) {
            heap.add(num);
            if(heap.size() > k)
                heap.poll();
        }
        Integer res = heap.peek();
        if(res == null)
            return -1;
        return res;
    }

    public static void main(String[] args) {
        Problem215_KthLargestElementInAnArray p = new Problem215_KthLargestElementInAnArray();
        System.out.println(p.findKthLargest(new int[]{3,2,1,5,6,4}, 2));            // 5
        System.out.println(p.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));      // 4
    }
}
