package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] solution(int[] nums, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            int remainder = sum - nums[i];
            if (map.containsKey(remainder)) {
                result = new int[]{map.get(remainder), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {2, 1, 5, 3};
        int sum = 4;
        //Output = [1,3]
        System.out.println(Arrays.toString(solution(nums, sum)));
    }

    @Test
    public void test2() {
        int[] nums = {2, 1, 5, 3};
        int sum = 5;
        //Output = [0,3]
        System.out.println(Arrays.toString(solution(nums, sum)));
    }

}
