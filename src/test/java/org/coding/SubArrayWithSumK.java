package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=fFVZt-6sgyo
//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubArrayWithSumK {

    /*
    Given an array of integers nums and an integer k,
    return the total number of continuous sub arrays whose sum equals to k.
     */
    //Bruteforce O(n^3) and O(1)
    private int solution(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //Cumulative sum
    //O(n^2)
    //O(n)
    private int solution1(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        int[] sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //O(n^2), O(1)
    //prefix sum
    private int solution2(int[] nums, int k) {

        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //

    //https://www.youtube.com/watch?v=HbbYPQc-Oo4
    //due negative numbers in array, prefix sum will vary
    //we can add each prefix (accumulative sum) to the map with no. of times that sum occurred in sub array
    //if prefix sum = 7 we can straightway add +1 to the count
    //but if prefix is not equal to sum, we can subtract k from that and check if map already contains that sum
    //with previous numbers.
    //O(n)
    private int solution3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum += n;

            if (sum == k) {
                count++;
            }

            if (map.containsKey(sum - k)) {
                Integer value = map.get(sum - k);
                count += value;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    @Test
    public void test0() {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println(solution(nums, k));
        System.out.println(solution1(nums, k));
        System.out.println(solution2(nums, k));
        System.out.println(solution3(nums, k));

        //4
    }


    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(solution(nums, k));
        System.out.println(solution1(nums, k));
        System.out.println(solution2(nums, k));
        System.out.println(solution3(nums, k));
        //2
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution(nums, k));
        System.out.println(solution1(nums, k));
        System.out.println(solution2(nums, k));
        System.out.println(solution3(nums, k));
        //2
    }


    @Test
    public void test3() {
        int[] nums = {1, -1, 0};
        int k = 0;
        System.out.println(solution(nums, k));
        System.out.println(solution1(nums, k));
        System.out.println(solution2(nums, k));
        System.out.println(solution3(nums, k));
        //2
    }

}
