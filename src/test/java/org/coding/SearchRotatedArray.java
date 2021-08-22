package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=QdVrY3stDD4
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchRotatedArray {

    //its a combination of finding min element in sorted array and normal binary with extra condition
    private int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //first find smallest index first
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //left contains smallest index
        int start = left;
        left = 0;
        right = nums.length - 1;

        //we have got 3 points now
        //start is the point of smallest element in the rotated search
        //4,5,6,7,0,1,2 target =3
        //left of min element (0 here) will have
        //now between 2 halves we need to find which half to seach
        //condition -> is the target number greater equal to start and less equal to end
        //in our example, the target >= 0 && target <= 2, i.e. I need to search current half
        //left should be set as start
        //else I need to search in other half, i.e. right = start
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        //from here normal binary serach
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }


    @Test
    public void test1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(solution(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        System.out.println(solution(nums, target));
    }

}
