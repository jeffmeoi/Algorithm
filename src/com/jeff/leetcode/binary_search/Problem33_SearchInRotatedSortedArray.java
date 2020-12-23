package com.jeff.leetcode.binary_search;

public class Problem33_SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {

        if(nums.length == 0)
            return -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l+r) / 2;
            if(nums[mid] == target)
                return mid;
            if(r - l <= 1 && nums[l] != target && nums[r] != target) {
                return -1;
            }
            if (nums[mid] < nums[0]) {     // 右边有序
                if(target > nums[mid] && target <= nums[nums.length-1]){
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            } else {
                if(target <= nums[mid] && target >= nums[0]){
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Problem33_SearchInRotatedSortedArray problem33_searchInRotatedSortedArray = new Problem33_SearchInRotatedSortedArray();
        System.out.println(problem33_searchInRotatedSortedArray.search(new int[]{3, 1}, 1));
        System.out.println(problem33_searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(problem33_searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(problem33_searchInRotatedSortedArray.search(new int[]{1}, 0));
    }
}
