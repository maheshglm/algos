package org.facebook;

import org.junit.Test;

//https://www.geeksforgeeks.org/longest-increasing-subarray/
public class MaxIncreasingSubArray {

    private int solution(int[] nums) {

        if (nums.length < 1) {
            return -1;
        }

        if (nums.length == 1) {
            System.out.println(nums[0]);
            return nums.length;
        }

        int maxLength = Integer.MIN_VALUE;
        int i = 1;
        int tempLen = 1;
        int endEndIndex = 0;

        while (i < nums.length) {
            if (nums[i] > nums[i - 1]) {
                tempLen++;
            } else {
                tempLen = 1;
            }
            if (maxLength < tempLen) {
                maxLength = tempLen;
                endEndIndex = i;
            }
            i++;
        }
        int startIndex = endEndIndex - maxLength + 1;

        for (int j = startIndex; j <= endEndIndex; j++) {
            System.out.print(nums[j] + " ");
        }
        System.out.println();
        return maxLength;
    }

    @Test
    public void test1() {
        int[] nums = {5, 6, 3, 5, 7, 8, 9, 1, 2};
        //output = {3, 5, 7, 8, 9} = 5
        System.out.println(solution(nums));
    }

    @Test
    public void test2() {
        int[] nums = {12, 13, 1, 5, 4, 7, 8, 10, 10, 11};
        //Output = {4, 7, 8, 10} = 4
        System.out.println(solution(nums));
    }

    @Test
    public void test3() {
        int[] nums = {};
        //Output = -1
        System.out.println(solution(nums));
    }

    @Test
    public void test4() {
        int[] nums = {5};
        //Output = {5} = 1
        System.out.println(solution(nums));
    }

    @Test
    public void test5() {
        int[] nums = {5, -1, 2, 6, 8, 0, 4, 3, 55, 21};
        //Output = 4 (-1, 2, 6, 8)
        System.out.println(solution(nums));
    }

    @Test
    public void test6() {
        int[] nums = {5, 7, 2, 6, 8, 20, 4, 3, 55, 21};
        //Output = 4 (2 6 8 20)
        System.out.println(solution(nums));
    }

    @Test
    public void test7() {
        int[] nums = {8, 6, 7};
        //Output = 2 (6,7)
        System.out.println(solution(nums));
    }

    @Test
    public void test8() {
        int[] nums = {8, 8, 8, 8};
        //Output = 1)
        System.out.println(solution(nums));
    }
}
