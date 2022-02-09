package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
public class MinimumTaps {

    private int solution(int[] ranges, int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < ranges.length; i++) {
            int min = Math.max(i - ranges[i], 0);
            int max = i + ranges[i];
            dp[min] = Math.max(dp[min], max);
        }

        //from here Jump Game 2
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < ranges.length) {
            int farthest = 0;
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(dp[i], farthest);
            }
            left = right + 1;
            right = farthest;
            result++;

            if (right < left) break;

            if (right >= ranges.length - 1) {
                return result;
            }
        }
        return -1;
    }


    @Test
    public void test1() {
        int[] arr = {3, 4, 1, 1, 0, 0};
        int n = 5;
        System.out.println(solution(arr, n));
        //output 1
        /*
        Explanation:
        The tap at point 0 can cover the interval [-3,3]
        The tap at point 1 can cover the interval [-3,5]
        The tap at point 2 can cover the interval [1,3]
        The tap at point 3 can cover the interval [2,4]
        The tap at point 4 can cover the interval [4,4]
        The tap at point 5 can cover the interval [5,5]
        Opening Only the second tap will water the whole garden [0,5]
         */
    }

    @Test
    public void test2() {
        int[] arr = {0, 0, 0, 0};
        int n = 3;
        System.out.println(solution(arr, n));
        //Explanation: Even if you activate all the four taps you cannot water the whole garden.
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 1, 0, 2, 1, 0, 1};
        int n = 7;
        System.out.println(solution(arr, n));
        //3
        /*
        The tap at point 0 can cover the interval [-1, 1]
        The tap at point 1 can cover the interval [-1, 3]
        The tap at point 2 can cover the interval [1, 3]
        The tap at point 3 can cover the interval [3, 3]
        The tap at point 4 can cover the interval [2, 6]
        The tap at point 5 can cover the interval [4, 6]
        The tap at point 5 can cover the interval [6, 6]
        The tap at point 5 can cover the interval [6, 8]

        Opening Only the second tap will water the whole garden [0,5]

         */

    }

}
