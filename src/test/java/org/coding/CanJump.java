package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=Zb4eRjuPHbM
//https://leetcode.com/problems/jump-game/
//https://www.youtube.com/watch?v=dJ7sWiOoK7g
public class CanJump {

    /*
    Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.
     */

    public boolean solution(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }

    //This is also good
    public boolean solution1(int[] nums) {
        int maxIndex = nums.length - 1;
        int maxJump = 0;
        for (int i = 0; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= maxIndex) return true;
        }
        return false;
    }


    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        /*
        lastIndex = 4
            i = 4
            4 + num[4] >= 4 -> 4 + 4 >= 4 true
            lastIndex = 4
            i = 3
            3 + num[3] >= 4 -> 3 + 1 >= 4 true
            lastIndex = 3
            i = 2
            2 + num[2] >= 3 -> 2 + 1 >= 3 true
            lastIndex = 2
            i = 1
            1 + num[1] >= 2 -> 1 + 3 >= 2 true
            lastIndex = 1
            i = 0
            0 + num[0] => 0 + 2 >= 1 true
            lastIndex = 0
        */
        //true
        //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //false
        //You will always arrive at index 3 no matter what.
        //Its maximum jump length is 0, which makes it impossible to reach the last index.
        /*
        lastIndex = 4
        i = 4
        i + nums[i] >= 4 -> 4 + 4 >= 4 - true
        lastIndex = 4
        i = 3
        3 + nums[3] -> 3 + 0 >= 4 false
        lastIndex = 4
        i = 2
        2 + nums[2] -> 2 + 1 >= 4 false
        lastIndex = 4
        ....

         */
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
    }
}
