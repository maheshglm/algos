package org.facebook;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=7To3kFD1eK4&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=141
public class ElementRange {

    private int[] solution(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;

        int first = findFirst(nums, target);

        if (first == -1) {
            return result;
        }

        int last = findLast(nums, target);

        result[0] = first;
        result[1] = last;

        return result;

    }

    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }


    @Test
    public void test1() {
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;

        //Output 3, 5
        System.out.println(Arrays.toString(solution(nums, target)));

    }

    @Test
    public void test2() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;

        //Output -1, -1
        System.out.println(Arrays.toString(solution(nums, target)));
    }
}
