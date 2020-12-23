package org.facebook;

import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesArray {

    //In place modification of array
    //Space O(1)
    public int solution1(int[] nums) {
        int pointer = 1; //There is reason why it is 1. because 0th pointer element cannot be swapped
        //it should remain in the array, we just need to override the next element if 0th pointer has
        //duplicate at 1st pointer

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[pointer] = nums[i + 1];
                pointer++;
            }
        }
        return pointer;
    }


    @Test
    public void test1() {
        int[] a = {1, 1, 2};
        System.out.println(solution1(a));
        //output= 2, nums [1,2]
    }

    @Test
    public void test2() {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution1(a));
        //output= 5, nums = [0,1,2,3,4]
    }

}
