package org.coding;

import org.junit.Test;

import java.util.*;

//https://www.youtube.com/watch?v=j9_qWJClp64
//https://www.youtube.com/watch?v=IER1ducXujU - Good
//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {

    /*
    Given a collection of candidate numbers (candidates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.
     */

    public List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        dfs(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                combination.add(candidates[i]);
                dfs(candidates, target - candidates[i], result, combination, i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    @Test
    public void test1() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(solution(candidates, target));
        //[1, 2, 2], [5]
    }

    @Test
    public void test2() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(solution(candidates, target));
        //[1,1,6], [1,2,5], [1,7], [2,6]
    }
}
