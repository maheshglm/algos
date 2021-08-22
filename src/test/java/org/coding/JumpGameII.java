package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    You can assume that you can always reach the last index.
     */

    /*
       left = 0
       right = 0
       until right != end index
       farthest = 0;
       i = left => 0 to 1
           farthest = max(0, 0+2) => 2
       left = 1
       right = 2
       count++

       i = 1
       farthest = max(0, 1 + 3) = 4
       i = 2
       farthest = max(4, 2 + 2) = 4

       left = 3
       right = farthest = 4
       count++

   */

    private int solution(int[] nums) {
        int left = 0;
        int right = 0;
        int result = 0;

        while (right < nums.length - 1) {
            int fathest = 0;
            for (int i = left; i < right + 1; i++) {
                fathest = Math.max(fathest, i + nums[i]);
            }
            left = right + 1;
            right = fathest;
            result++;
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 1, 4};
        //2
        //Explanation: The minimum number of jumps to reach the last index is 2.
        //Jump 1 step from index 0 to 1, then 3 steps to the last index.
    }

    @Test
    public void test2() {
        int[] nums = {2, 3, 0, 1, 4};
        //2
    }

}
