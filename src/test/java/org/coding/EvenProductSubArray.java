package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.hackerearth.com/problem/algorithm/even-subarray-2-641faa7a/
public class EvenProductSubArray {


    private int solution(int[] nums) {
        int n = nums.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                if (product % 2 == 0) {
                    count++;
                }
            }

        }
        return count;
    }

    //Naive approach O(N^2) to print subarrays
    private List<List<Integer>> solution1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * nums[j];
                temp.add(nums[j]);
                if (product % 2 == 0) {
                    result.add(new ArrayList<>(temp));
                }
            }
        }
        return result;
    }

    /*  i = 0
        product = 3
        temp [3]
                j = 1
                product = 15
                temp[3, 5]

                j = 2
                product = 30
                temp [3, 5, 2]
                result = [3, 5, 2]

                j = 3
                product = 90
                temp [3, 5, 2, 3]
                result [3, 5, 2] [3, 5, 2, 3]

        i = 1
        product = 5
        temp [5]
             j = 2
             product = 10
             temp [5, 2]
             result [3, 5, 2] [3, 5, 2, 3] [5, 2]

             j = 3
             product = 30
             temp [5, 2, 3]
     */


    @Test
    public void test1() {
        int[] nums = {3, 5, 2, 3};
        System.out.println(solution1(nums));

        //[2],[5, 2], [2, 3], [3, 5, 2], [5, 2, 3], [3, 5, 2, 3]
        //[3, 5, 2], [3, 5, 2, 3], [5, 2], [5, 2, 3], [2], [2, 3]
        //[3, 5, 2], [3, 5, 2, 3], [5, 2], [5, 2, 3], [2], [2, 3]

    }

    @Test
    public void test2() {
        int[] nums = {7, 5, 4, 9};
        System.out.println(solution1(nums));
        //[[7, 5, 4], [7, 5, 4, 9], [5, 4], [5, 4, 9], [4], [4, 9]]
        //[[7, 5, 4], [7, 5, 4, 9], [5, 4], [5, 4, 9], [4], [4, 9]]
        /*
        { 4 }
        { 5, 4 }
        { 7, 5, 4 }
        { 7, 5, 4, 9 }
        { 5, 4, 9 }
        { 4, 9 }
         */
    }

    @Test
    public void test3() {
        int[] nums = {1, 3, 5};
        System.out.println(solution1(nums));

        //0
    }


}
