package com.jeff.leetcode.double_pointer;

/**
 * 从nums1尾部开始合并nums1和nums2
 */
public class Problem88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m-1, pos2 = n-1;
        int current = nums1.length - 1;
        while (current >= 0) {
            if(pos2 < 0 || (pos1 >= 0 && nums1[pos1] >= nums2[pos2])) {
                nums1[current--] = nums1[pos1--];
            } else {
                nums1[current--] = nums2[pos2--];
            }
        }
    }

    public static void main(String[] args) {
        Problem88_MergeSortedArray problem88_mergeSortedArray = new Problem88_MergeSortedArray();
        int [] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        problem88_mergeSortedArray.merge(nums1, 3, new int[]{2, 5, 6}, 3);
    }

}
