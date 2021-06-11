package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {

    /*
    Given a sorted array of distinct integers and a target value,
    return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.
     */
    /*
    Also notice that the input target might be larger than all elements in nums and thus needs to placed at the end of the array.
    That’s why we should initialize right = len(nums) instead of right = len(nums) — 1 .
     */
    private int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(solution(nums, target)); //2
    }

    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(solution(nums, target)); //1
    }

    @Test
    public void test3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(solution(nums, target)); //4
    }

    @Test
    public void tes4() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        System.out.println(solution(nums, target)); //0
    }

}
