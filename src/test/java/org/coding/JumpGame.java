package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/jump-game/
public class JumpGame {

    //determine canJump or not

    private boolean solution(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i <= maxJump; i++) {
            maxJump = Math.max(maxJump, nums[i] + i);
            if (maxJump >= nums.length - 1) return true;
        }
        return false;
    }


    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 1, 4};
        //true

    }
}
