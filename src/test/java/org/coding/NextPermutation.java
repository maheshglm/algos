package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://www.youtube.com/watch?v=PYXl_yY-rms
public class NextPermutation {


    //from the end we need to find out longest increasing sequence.
    //6, 2, 1, 5, 4, 3, 0
    //k = 5 (last but one index) compare with next element
    //nums[5] > nums[6] -> nums[4] > nums[5] -> nums[3] > nums[4] -> nums[2] > nums[3] false
    //k = 2
    //if k = -1, i.e. we reached last index, which means whole array is sorted in descending order
    //in that case we need to reverse entire array as per requirement to make array lexographically sorted.

    //if k != -1
    //above example k = 2, which means, 2nd index is not in sequence.
    //we need to find a number from end to 2nd index to find first largest element than kth element
    //below example it checks for nums[k] < nums[l]
    //nums[2] < nums[6] -> 2 < 0 false
    //nums[2] < nums[5] -> 2 < 3 true -- swap numbers
    //6, 2, 1, 5, 4, 3, 0 -> 6, 2, 3, 5, 4, 1, 0

    //now arrange all elements from k+1 to end in ascending order
    ///6, 2, 3, 5, 4, 1, 0 -> 6, 2, 3, 0, 1, 4, 5


    private void solution(int[] nums) {
        int k = nums.length - 2;
        while (k >= 0 && nums[k] > nums[k + 1]) {
            k--;
        }

        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int l = nums.length - 1; l > k; l--) {
            if (nums[l] > nums[k]) {
                int temp = nums[l];
                nums[l] = nums[k];
                nums[k] = temp;
                break;
            }
        }
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        //output {1, 3, 2}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 1};
        //output {1, 2, 3}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 5};
        //output {1, 5, 1}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test4() {
        int[] nums = {6, 2, 1, 5, 4, 3, 0};
        //output {6,2,3,0,1,4,5}
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }


}
