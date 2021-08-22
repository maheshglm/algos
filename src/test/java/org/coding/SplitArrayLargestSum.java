package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=eEvLI9i02Zw - Best explanation
//https://www.youtube.com/watch?v=8_FivWxrSK0
//https://leetcode.com/problems/split-array-largest-sum/
//https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java
public class SplitArrayLargestSum {


    /*  Given an array nums which consists of non-negative integers and an integer m,
        you can split the array into m non-empty continuous sub arrays.
        Write an algorithm to minimize the largest sum among these m sub arrays.
     */

    //using binary search between the sums
    private int solution1(int[] nums, int m) {
        int minVal = Arrays.stream(nums).max().getAsInt();
        int maxVal = Arrays.stream(nums).sum();

        while (minVal < maxVal) {
            int mid = minVal + (maxVal - minVal) / 2;
            if (countSubArrays(nums, mid) <= m) {
                //if (canSplit(nums, mid, m)) {
                maxVal = mid;
            } else {
                minVal = mid + 1;
            }
        }
        return minVal;
    }


    private int countSubArrays(int[] nums, int maxSum) {
        int pieces = 1;
        int tempSum = 0;
        for (int num : nums) {
            if (tempSum + num > maxSum) {
                tempSum = num;
                pieces++;
            } else {
                tempSum += num;
            }
        }
        return pieces;
    }

    private boolean canSplit(int[] nums, int maxSum, int m) {
        int subSum = 0;
        int subCnt = 1;

        for (int num : nums) {
            subSum += num;
            if (subSum > maxSum) {
                subCnt++;
                subSum = num;
                if (subCnt > m) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test1() {
        int[] nums = {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(solution1(nums, m)); //18
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        System.out.println(solution1(nums, m)); //9
    }

    @Test
    public void test3() {
        int[] nums = {1, 4, 4};
        int m = 3;
        System.out.println(solution1(nums, m)); //4
    }

}
