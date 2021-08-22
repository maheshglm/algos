package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/target-sum/
public class TargetSum {

    //https://leetcode.com/problems/target-sum/discuss/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions.
    int count = 0;

    public int solution(int[] nums, int target) {
        calculate(nums, target, 0);
        return count;
    }

    //recursion - similar to 0-1Knapsack problem
    //O(2 ^ n)
    //O(n)
    private void calculate(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) {
                count++;
            }
        } else {
            calculate(nums, target + nums[index], index + 1);
            calculate(nums, target - nums[index], index + 1);
        }
    }

    //Time O(n*c) - c is the target, n number of elements
    //Space O(n*c) - for map c, and n for recutsion calls
    public int solution1(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return calculate(nums, target, 0, memo);
    }

    private int calculate(int[] nums, int target, int index, Map<String, Integer> memo) {
        if (index == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            String key = index + "," + target;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            int way1 = calculate(nums, target + nums[index], index + 1, memo);
            int way2 = calculate(nums, target - nums[index], index + 1, memo);
            memo.put(key, way1 + way2);
            return memo.get(key);
        }
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution1(nums, target)); //5 ways
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int target = 1;
        System.out.println(solution1(nums, target)); //1 ways
        //1
    }

    @Test
    public void test3() {
        int[] nums = {2, 20, 24, 38, 44, 21, 45, 48, 30, 48, 14, 9, 21, 10, 46, 46, 12, 48, 12, 38};
        int target = 48;
        System.out.println(solution1(nums, target)); //5401 ways
        System.out.println(solution(nums, target)); //5401 ways
        //1
    }
}
