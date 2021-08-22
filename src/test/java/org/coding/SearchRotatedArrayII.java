package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//https://www.youtube.com/watch?v=XsAK1r3BmJk
public class SearchRotatedArrayII {


    private boolean solution1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target || nums[right] == target) {
                return true;
            }
            if (nums[left] < target) {
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            } else {
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
            }
        }
        return false;
    }

    private boolean solution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        //check each num so we will check left == right
        //We always get a sorted part and a half part
        //we can check sorted part to decide where to go next
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;

            //if left part is sorted
            if (nums[left] < nums[mid]) {
                if (target < nums[left] || target > nums[mid]) {
                    //target is in rotated part
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] > nums[mid]) {
                //right part is rotated

                //target is in rotated part
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //duplicates, we know nums[mid] != target, so nums[left] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                left++;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        //binary search will not work in duplicates
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        int target = 2;
        System.out.println(solution(nums, target));
        System.out.println(solution1(nums, target)); //true
        //true
        int[] bulbs = new int[3];//000000
        Arrays.fill(bulbs, 1);

        int debug = 1;
    }
}
