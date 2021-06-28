package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    /*
    Given an array of distinct integers candidates and a target integer target,
    return a list of all unique combinations of candidates where the chosen numbers sum to target.
    You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times.
    Two combinations are unique if the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     */

    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int index) {
        if (index >= candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        if (candidates[index] <= target) {
            temp.add(candidates[index]);
            dfs(candidates, target - candidates[index], result, temp, index);
            temp.remove(temp.size() - 1);
        }
        dfs(candidates, target, result, temp, index + 1);
    }


    @Test
    public void test1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution(candidates, target));
        /*
        Output: [[2,2,3],[7]]
        Explanation:
        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        7 is a candidate, and 7 = 7.
        These are the only two combinations.
         */
    }

    @Test
    public void test2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        //Output: [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(solution(candidates, target));
    }

    @Test
    public void test3() {
        int[] candidates = {1};
        int target = 1;
        //Output: [[1]]
        System.out.println(solution(candidates, target));
    }

    @Test
    public void test4() {
        int[] candidates = {1};
        int target = 2;
        //Output: [[1,1]]
        System.out.println(solution(candidates, target));
    }
}
