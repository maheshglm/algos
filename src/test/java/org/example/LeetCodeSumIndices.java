package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeSumIndices {

    private int[] solution(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    @Test
    public void test1() {
        int[] nums = {2, 7, 8, 11};
        int target = 9;
        int[] solution = solution(nums, target);
        System.out.println(Arrays.toString(solution));
    }
}
