package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/subarray-product-less-than-k/
//https://www.youtube.com/watch?v=SxtxCSfSGlo
public class SubArraysWithProduct {

    //sliding window O(n)
    private int solution(int[] nums, int k) {
        if (k <= 0 || nums.length == 0) return 0;

        int left = 0;
        int right = 0;
        int product = 1;
        int result = 0;
        while (right < nums.length) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }


    @Test
    public void test1() {
        int[] arr = {10, 5, 2, 6};
        int k = 100;
        System.out.println(solution(arr, k));
        //8
        /*
        Explanation: The 8 subarrays that have product less than 100 are:
        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
        Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
         */
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3};
        int k = 0;
        System.out.println(solution(arr, k));
        //0
    }

    @Test
    public void test3() {
        int[] arr = {1, 1, 1};
        int k = 1;
        System.out.println(solution(arr, k));
        //0
    }

    @Test
    public void test4() {
        int[] arr = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;
        System.out.println(solution(arr, k));
        //18
    }

}
