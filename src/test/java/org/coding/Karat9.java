package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
public class Karat9 {

    /*
    Given two integer arrays nums1 and nums2,
    return the maximum length of a sub array that appears in both arrays.
    */

    private int solution(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    result = Math.max(result, memo[i][j]);
                } else {
                    memo[i][j] = 0;
                }
            }
        }
        return result;
    }


    private int solution1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        return helper(nums1, nums2, 0, 0, 0, new HashMap<>());
        //return helper(nums1, nums2, 0, 0, 0);
    }

    private int helper(int[] nums1, int[] nums2, int i, int j, int maxLen) {
        if (i >= nums1.length || j >= nums2.length) {
            return maxLen;
        }

        if (nums1[i] == nums2[j]) {
            maxLen = helper(nums1, nums2, i + 1, j + 1, maxLen + 1);
        }

        return Math.max(maxLen, Math.max(helper(nums1, nums2, i, j + 1, 0),
                helper(nums1, nums2, i + 1, j, 0)));
    }

    private int helper(int[] nums1, int[] nums2, int i, int j, int maxLen, Map<String, Integer> memo) {
        if (i >= nums1.length || j >= nums2.length) {
            return maxLen;
        }

        String key = i + "" + j + "" + maxLen;

        if (memo.containsKey(key)) {
            memo.get(key);
        }

        if (nums1[i] == nums2[j]) {
            maxLen = helper(nums1, nums2, i + 1, j + 1, maxLen + 1, memo);
        }

        int max = Math.max(maxLen, Math.max(helper(nums1, nums2, i, j + 1, 0, memo),
                helper(nums1, nums2, i + 1, j, 0, memo)));

        memo.put(i + "" + j + "" + max, max);

        return max;
    }


    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(solution(nums1, nums2));
        System.out.println(solution1(nums1, nums2));

        //output = 3 The repeated sub array with maximum length is [3,2,1].
    }

    @Test
    public void test2() {
        int[] nums1 = {5, 14, 53, 80, 48};
        int[] nums2 = {50, 47, 3, 80, 83};
        System.out.println(solution(nums1, nums2));
        System.out.println(solution1(nums1, nums2));

        //output 1
    }

    @Test
    public void test3() {
        int[] nums1 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};

        //Output 9

        System.out.println(solution(nums1, nums2));
        System.out.println(solution1(nums1, nums2));

    }

}
