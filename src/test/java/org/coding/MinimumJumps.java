package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/jump-game-ii/
//https://www.youtube.com/watch?v=dJ7sWiOoK7g
public class MinimumJumps {

    public int solution(int[] nums) {
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length - 1) {
            int farthest = 0;
            for (int i = left; i < right+1; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right + 1;
            right = farthest;
            result++;
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution(nums));
        //2
        /*
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
        then 3 steps to the last index.
         */
    }

    @Test
    public void test2() {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(solution(nums));
        //2

    }

    @Test
    public void test3() {
        int[] nums = {2, 2, 0, 1, 4};
        System.out.println(solution(nums));
        //3

    }

}
