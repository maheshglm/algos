package org.coding;


import org.junit.Test;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {

    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     */
    //logic is, start from actual size of nums1 nums1.length-1
    //iterate real numbers from nums1 and nums2
    //whichever is bigger place it in the last
    //if we run out of nums2 then break
    private void solution(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;

        for (int k = nums1.length - 1; k >= 0; k--) {
            if (j < 0) {
                break;
            }
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;//since we are decrementing i, it is safe to check i is in boundaries
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3; //i.e. means there are 3 numbers in nums1 occupied
        int[] nums2 = {2, 5, 6};
        int n = 3; //3 numbers in nums2
        //output nums1 should be [1, 2, 2, 3, 5, 6]
    }

    @Test
    public void test2() {
        int[] nums1 = {0};
        int m = 0; //i.e. means there are 3 numbers in nums1 occupied
        int[] nums2 = {1};
        int n = 1; //3 numbers in nums2
        //output nums1 should be [1]
    }


}
