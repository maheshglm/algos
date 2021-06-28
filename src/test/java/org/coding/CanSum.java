package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2328s
public class CanSum {

    //Takes target sum and array of numbers as arguments
    //Function should return boolean to indicate whether or not it is possible to generate the target sum
    //using numbers from the array

    //you may use element of an array as many times you want

    //O(n^m) time, height of the tree is space complexity O(m)
    //It is slow
    private boolean solution(int[] arr, int sum) {
        if (sum == 0) return true;
        if (sum < 0) return false;

        for (int a : arr) {
            if (solution(arr, sum - a)) {
                return true;
            }
        }
        return false;
    }

    //O(m*n) is the time, and O(m) is the space
    private boolean solution1(int[] arr, int sum, Map<Integer, Boolean> memo) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if (sum == 0) return true;
        if (sum < 0) return false;

        for (int a : arr) {
            int reminder = sum - a;
            if (solution1(arr, reminder, memo)) {
                memo.put(sum, true);
                return memo.get(sum);
            }
        }
        memo.put(sum, false);
        return memo.get(sum);
    }

    @Test
    public void test1() {
        int[] arr = {5, 3, 4, 7};
        int sum = 7;
        //System.out.println(solution(arr, sum)); //true
        System.out.println(solution1(arr, sum, new HashMap<>())); //true
    }

    @Test
    public void test2() {
        int[] arr = {5, 3, 5, 8};
        int sum = 7;
        System.out.println(solution(arr, sum)); //false
        System.out.println(solution1(arr, sum, new HashMap<>())); //false
    }

    @Test
    public void test3() {
        int[] arr = {7, 14};
        int sum = 300;
        //ystem.out.println(solution(arr, sum)); //false
        System.out.println(solution1(arr, sum, new HashMap<>())); //false
    }


}
