package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

    //Same as CanSum but here function should return an array
    //containing any combination of elements that add up to exactly the target sum
    //if no elements then return null

    //Time - O(n^m * m) - m is for adding result to the array list which is same m i.e. sum times
    //space- O(m) - length of recursion calls
    private List<Integer> solution(int[] arr, int sum) {
        if (sum == 0) return new ArrayList<>();
        if (sum < 0) return null;

        for (int num : arr) {
            int reminder = sum - num;
            List<Integer> reminderResult = solution(arr, reminder);
            if (reminderResult != null) {
                reminderResult.add(num);
                return reminderResult;
            }
        }
        return null;
    }

    //m - targetsum
    //n - number of elements in array
    //Time - O(m*n*m) - O(nm^2)
    //Space - O(m * m) - O(m^2)
    private List<Integer> solution1(int[] arr, int sum, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if (sum == 0) return new ArrayList<>();
        if (sum < 0) return null;

        for (int num : arr) {
            int reminder = sum - num;
            List<Integer> reminderResult = solution1(arr, reminder, memo);
            if (reminderResult != null) {
                reminderResult.add(num);
                memo.put(sum, reminderResult);
                return reminderResult;
            }
        }
        memo.put(sum, null);
        return null;
    }


    @Test
    public void test1() {
        int[] arr = {5, 3, 4, 7};
        int sum = 7;
        //System.out.println(solution(arr, sum)); //4, 3
        System.out.println(solution1(arr, sum, new HashMap<>())); //4, 3
    }

    @Test
    public void test2() {
        int[] arr = {5, 3, 5, 8};
        int sum = 7;
        //System.out.println(solution(arr, sum)); //null
        System.out.println(solution1(arr, sum, new HashMap<>())); //null
    }

    @Test
    public void test3() {
        int[] arr = {7, 14};
        int sum = 300;
        //System.out.println(solution(arr, sum)); //null
        System.out.println(solution1(arr, sum, new HashMap<>())); //null
    }

    @Test
    public void test4() {
        int[] arr = {2, 3, 5};
        int sum = 8;
        System.out.println(solution(arr, sum)); //2222
        System.out.println(solution1(arr, sum, new HashMap<>())); //2222
    }
}
