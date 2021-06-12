package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
//801. Minimum Swaps To Make Sequences Increasing
public class RelativeSort {

    //Dynamic programming
    private int solution(int[] nums1, int[] nums2) {
        return 1;
    }


    @Test
    public void test1() {
        int[] nums1 = {1, 3, 5, 4};
        int[] nums2 = {1, 2, 3, 7};

        System.out.println(solution(nums1, nums2)); //output = 1
        //Explanation:
        //Swap nums1[3] and nums2[3].  Then the sequences are:
        //nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
        //which are both strictly increasing.
    }

    @Test
    public void test2() {
        int[] nums1 = {0, 4, 4, 5, 9};
        int[] nums2 = {0, 1, 6, 8, 10};
        System.out.println(solution(nums1,nums2));//output = 1
    }
}
