package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
public class SubArraysWithOddSum {


    /*
    Given an array of integers arr. Return the number of sub-arrays with odd sum.
    As the answer may grow large, the answer must be computed modulo 10^9 + 7.
     */

    //odd + odd = even
    //even + even = even
    //odd + even  = odd
    private int solution(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long odd = 0;
        for (int j : prefix) {
            if (j % 2 != 0)
                odd += j % 2;
        }

        long even = n + 1 - odd;
        return ((int) (odd * even) % 1000000007);
    }

    @Test
    public void test1() {
        int[] arr = {1, 3, 5};
        System.out.println(solution(arr));
        //4
        /*
        Explanation: All sub-arrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
        All sub-arrays sum are [1,4,9,3,8,5].
        Odd sums are [1,9,3,5] so the answer is 4.
         */
    }

    @Test
    public void test2() {
        int[] arr = {2, 4, 6};
        System.out.println(solution(arr));
        //0
        /*
        Explanation: All sub-arrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
         */
    }

    @Test
    public void test3() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution(arr));
        //16
    }

    @Test
    public void test4() {
        int[] arr = {100, 100, 99, 99};
        System.out.println(solution(arr));
        //4
    }

    @Test
    public void test5() {
        int[] arr = {7};
        System.out.println(solution(arr));
        //1
    }
}
