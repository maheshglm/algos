package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {

    /*  Given an array nums which consists of non-negative integers and an integer m,
        you can split the array into m non-empty continuous sub arrays.
        Write an algorithm to minimize the largest sum among these m sub arrays.
     */

    //using brute force solution
    private int solution1(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        for (int i = left; i <= right; i++) {
            
        }
        return 1;
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
