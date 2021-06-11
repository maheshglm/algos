package org.coding;

import org.junit.Test;

public class MaxSubArrayOfSize {

    private int solution1(int[] nums, int size) {
        int i = 0;
        int j = 0;
        int runningSum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (i < nums.length) {
            runningSum += nums[i];
            if (i - j == size - 1) {
                maxSum = Math.max(maxSum, runningSum);
                runningSum = runningSum - nums[j];
                j++;
            }
            i++;
        }
        return maxSum;
    }

    @Test
    public void test0() {
        int[] nums = {4, 2, 1, 7, 8, 6};
        int size = 2;
        //output = 15
        System.out.println(solution1(nums, size));
    }

    @Test
    public void test1() {
        int[] nums = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
        int size = 3;
        //output = 16
        System.out.println(solution1(nums, size));
    }
}
