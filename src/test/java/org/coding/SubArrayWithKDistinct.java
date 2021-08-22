package org.coding;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/1261290/Java-98.40-faster-with-explanations
//https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubArrayWithKDistinct {


    //https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC%2B%2BPython-Sliding-Window
    //if it asks the number of subarrays with at most K distinct elements.
    //Just need one more step to reach the follwing equation:
    //exactly(K) = atMost(K) - atMost(K-1)
    private int solution(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    //It is similar to LongestSubStringWithKDistinct.java program
    //
    private int atMost(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(solution(nums, k));
        /*
        Output: 7
        Explanation:
        Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
         */
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 3;
        System.out.println(solution(nums, k));
        /*
        Output: 3
        Explanation:
        Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
         */
    }


}
