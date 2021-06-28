package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2328s
public class BestSum {

    //Same as HowSum but here function should return an array
    //containing shortest combination of elements that add up to exactly the target sum
    //if tie you may return any of the list
    //if no elements then return null


    //m = target sum
    //n = numbers .length
    //Time = O(n^m * m)
    //Space = O(m^2)
    public List<Integer> solution(int[] arr, int sum) {
        if (sum == 0) return new ArrayList<>();
        if (sum < 0) return null;

        List<Integer> shortestCombination = null;

        for (int num : arr) {
            int reminder = sum - num;
            List<Integer> reminderCombination = solution(arr, reminder);
            if (reminderCombination != null) {
                reminderCombination.add(num);
                if (null == shortestCombination || reminderCombination.size() < shortestCombination.size()) {
                    shortestCombination = reminderCombination;
                }
            }
        }
        return shortestCombination;
    }


    //m - sum
    //n - numbers.length
    //Time O(m * n * m)
    //Space: O(m * m)
    public List<Integer> solution1(int[] arr, int sum, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if (sum == 0) return new ArrayList<>();
        if (sum < 0) return null;

        List<Integer> shortestCombination = null;

        for (int num : arr) {
            int reminder = sum - num;
            List<Integer> reminderCombination = solution1(arr, reminder, memo);
            if (reminderCombination != null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num);
                list.addAll(reminderCombination);
                if (null == shortestCombination || list.size() < shortestCombination.size()) {
                    shortestCombination = list;
                }
            }
        }
        memo.put(sum, shortestCombination);
        return shortestCombination;
    }


    @Test
    public void test1() {
        int[] arr = {5, 3, 4, 7};
        int sum = 7;
        System.out.println(solution(arr, sum)); //[7]
        System.out.println(solution1(arr, sum, new HashMap<>())); //[7]
    }

    @Test
    public void test2() {
        int[] arr = {2, 3, 5};
        int sum = 8;
        System.out.println(solution(arr, sum)); //[5,3]
        System.out.println(solution1(arr, sum, new HashMap<>())); //[5,3]
    }

    @Test
    public void test3() {
        int[] arr = {1, 4, 5};
        int sum = 8;
        System.out.println(solution(arr, sum)); //[4,4]
        System.out.println(solution1(arr, sum, new HashMap<>())); //[4,4]
    }

    @Test
    public void test4() {
        int[] arr = {1, 2, 5, 25};
        int sum = 100;
        //System.out.println(solution(arr, sum)); //[25, 25, 25, 25]
        System.out.println(solution1(arr, sum, new HashMap<>())); //[25, 25, 25, 25]
    }

}
