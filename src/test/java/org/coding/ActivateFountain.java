package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/discuss/interview-question/363036/walmart-oa-2019-activate-fountains
public class ActivateFountain {


    private int solution1(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        int min;
        int max;

        for (int i = 0; i < n; i++) {
            min = Math.max(i - arr[i], 1);
            max = Math.min(i + arr[i], n);
            dp[min - 1] = Math.max(dp[min - 1], max);
        }

        int left = 0;
        int right = 0;
        int cnt = 0;
        while (right < n - 1) {
            int farthest = 0;
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, dp[i]);
            }

            left = right + 1;
            right = farthest;
            cnt++;
        }
        return cnt;
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 1};
        System.out.println(solution1(nums));
        //1
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 1};
        System.out.println(solution1(nums));
        //1
    }

    @Test
    public void test3() {
        int[] nums = {2, 0, 0, 0};
        System.out.println(solution1(nums));
        //2
    }

}
