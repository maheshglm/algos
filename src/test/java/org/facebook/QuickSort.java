package org.facebook;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=COk73cpQbFQ
public class QuickSort {

    private void solution(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(nums, start, end);

        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                pIndex++;
            }
        }

        int temp = nums[end];
        nums[end] = nums[pIndex];
        nums[pIndex] = temp;

        return pIndex;
    }

    @Test
    public void test1() {
        int[] nums = {9, 8, 3, 1, 4, 6, 2};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {9, 0};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = {0};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
