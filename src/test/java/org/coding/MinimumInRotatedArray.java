package org.coding;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//https://www.youtube.com/watch?v=QdVrY3stDD4
public class MinimumInRotatedArray {

    //O(N) time O(1) space
    private int solution(int[] nums) {
        int i = 0;
        while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
            i++;
        }

        if (i >= nums.length - 1)
            return nums[0];
        return nums[i + 1];
    }

    //O(logN)
    private int solution1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
