package org.facebook;

import org.junit.Test;

//https://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-ii-java/
public class RemoveDuplicatesArrayII {

    //Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
    private int solution2(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 2) return nums.length;

        int pointer = 2, i = 2;
        while (i < nums.length) {
            if (nums[i] != nums[pointer - 2]) {
                nums[pointer] = nums[i];
                pointer++;
            }
            i++;
        }
        return pointer;
    }


    @Test
    public void test1() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(solution2(nums)); //7
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(solution2(nums)); //5
    }

}
