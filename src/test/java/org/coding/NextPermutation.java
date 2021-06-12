package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=PYXl_yY-rms
public class NextPermutation {

    private void solution(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] > nums[k + 1]) {
            k--;
        }

        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int l = nums.length - 1; l > k; l--) {
            if (nums[l] > nums[k]) {
                int temp = nums[l];
                nums[l] = nums[k];
                nums[k] = temp;
                break;
            }
        }
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        //output {1, 3, 2}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 1};
        //output {1, 2, 3}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 5};
        //output {1, 5, 1}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = {6, 2, 1, 5, 4, 3, 0};
        //output {6,2,3,0,1,4,5}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }


}
