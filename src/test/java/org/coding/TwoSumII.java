package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=sAQT4ZrUfWo
public class TwoSumII {

    //we need to ask if it is sorted array.
    //if it is we can follow this approach
    private int[] solution1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("");
    }

    private int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i + 1};
            }
            map.put(nums[i], i + 1);
        }
        throw new IllegalArgumentException("");
    }

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        //Output = [1,2] //return not zero based
        System.out.println(Arrays.toString(solution2(nums, target)));
        System.out.println(Arrays.toString(solution1(nums, target)));
    }

    @Test
    public void test2() {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        //Output = [2,3] //return not zero based
        System.out.println(Arrays.toString(solution2(nums, target)));
        System.out.println(Arrays.toString(solution1(nums, target)));


    }
}
