package com.jeff.leetcode.simulation;

/**
 * O(m+n)方法，非题解
 */
public class Problem4_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length - 1) / 2;
        int i1 = 0, i2 = 0, current = 0;
        int[] res = new int[nums1.length + nums2.length];
        while((i1 < nums1.length || i2 < nums2.length) && current <= mid + 1) {
            if(i2 == nums2.length || (i1 < nums1.length && nums1[i1] < nums2[i2])) {
                res[current++] = nums1[i1++];
            } else {
                res[current++] = nums2[i2++];
            }
        }
        if((nums1.length + nums2.length) % 2 == 0) {
            return (res[mid] + res[mid+1]) / 2.0;
        } else
            return res[mid];
    }

    public static void main(String[] args) {
        Problem4_MedianOfTwoSortedArrays problem4_medianOfTwoSortedArrays = new Problem4_MedianOfTwoSortedArrays();
        System.out.println(problem4_medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));       // 2
        System.out.println(problem4_medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));    // 2.5
        System.out.println(problem4_medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}));    // 0
        System.out.println(problem4_medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {}, new int[] {1}));    // 1
        System.out.println(problem4_medianOfTwoSortedArrays.findMedianSortedArrays(new int[] {2}, new int[] {}));    // 2
    }

}
