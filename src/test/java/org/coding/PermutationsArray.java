package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
//https://leetcode.com/problems/permutations/
public class PermutationsArray {

    private List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> tempList, int index) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            if (tempList.contains(num)) continue;
            tempList.add(num);
            backtracking(nums, result, tempList, index + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        System.out.println(solution(nums));
        //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

    }


}
