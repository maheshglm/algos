package org.facebook;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=mB5HXBb_HY8
//https://www.youtube.com/watch?v=0ewhf9bqrJg&t=4s
public class MergeSort {

    public void solution(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low == high) {
            return;
        }

        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        if (left <= mid) {
            while (left <= mid) {
                temp[k++] = nums[left++];
            }
        } else {
            while (right <= high) {
                temp[k++] = nums[right++];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i + low] = temp[i];
        }

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
