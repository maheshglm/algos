package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

    public boolean solution(int[] arr, int sum) {
        return dynamicProgramming(arr, sum, 0, new HashMap<>());
        //return recursive(arr, sum, 0);
    }

    //backtracking 2^n
    public boolean recursive(int[] arr, int sum, int index) {
        if (sum == 0) return true;
        if (index >= arr.length) {
            return false;
        }
        boolean result1 = false;
        if (arr[index] <= sum) {
            result1 = recursive(arr, sum - arr[index], index + 1);
        }

        boolean result2 = recursive(arr, sum, index + 1);
        return result2 || result1;
    }

    public boolean dynamicProgramming(int[] arr, int sum, int index, Map<Integer, Boolean> memo) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if (sum == 0) return true;
        if (index >= arr.length) {
            return false;
        }
        boolean result1 = false;
        if (arr[index] <= sum) {
            result1 = recursive(arr, sum - arr[index], index + 1);
        }

        boolean result2 = recursive(arr, sum, index + 1);
        boolean result = result2 || result1;
        memo.put(sum, result);
        return result;
    }



    @Test
    public void test1() {
        int[] arr = {1, 2, 3};
        int sum = 5;
        Assert.assertTrue(solution(arr, sum));
        //true
    }

    @Test
    public void test2() {
        int[] arr = {3, 34, 4, 12, 4, 2};
        int sum = 9;
        Assert.assertTrue(solution(arr, sum));
    }

    @Test
    public void test3() {
        int[] arr = {3, 34, 4, 12, 4, 2};
        int sum = 35;
        Assert.assertFalse(solution(arr, sum));
    }
}
