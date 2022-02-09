package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {

    //Divide and Concur -- Complex
    public int solution3(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    public int maxSubArraySum(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (low + high) / 2;
        int leftMaxSum = maxSubArraySum(nums, low, mid);
        int rightMaxSum = maxSubArraySum(nums, mid + 1, high);
        int crossMaxSum = crossSectionMaxSum(nums, low, mid, high);

        int max = Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);

        System.out.println("Appearing once for max " + max);

        return max;
    }

    private int crossSectionMaxSum(int[] nums, int low, int mid, int high) {
        int left_max_sum = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            left_max_sum = Math.max(sum, left_max_sum);
        }

        sum = 0;
        int right_max_sum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            right_max_sum = Math.max(sum, right_max_sum);
        }
        return left_max_sum + right_max_sum;
    }

    //O(N)
    //Space O(1)
    public int solution1(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    //O(n^2) Brute force
    public int solution(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int subSum = 0;
            for (int j = i; j < nums.length; j++) {
                subSum += nums[j];
                sum = Math.max(sum, subSum);
            }
        }
        return sum;
    }

    @Test
    public void test0() {
        int[] nums = {1, -3, 2, 1, -1};
        //output = 3
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        System.out.println(solution3(nums));
    }

    @Test
    public void test1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //output = 6 [4,-1,2,1]
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1};
        //output = 1
    }

    @Test
    public void test3() {
        int[] nums = {0};
        //output = 0
    }

    @Test
    public void test5() {
        int[] nums = {0, 0};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //output = 0
    }

    @Test
    public void test4() {
        int[] nums = {-1};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //output = -1
    }


}
