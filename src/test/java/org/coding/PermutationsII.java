package org.coding;

import org.junit.Test;

import java.util.*;


//https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=495s
//https://leetcode.com/problems/permutations-ii/solution/
public class PermutationsII {

    private List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, result, new ArrayList<>(), visited);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            //to skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;

            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, result, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        backtrack(nums, results, new ArrayList<>(), countMap);
        return results;
    }

    public void backtrack(int[] nums, List<List<Integer>> results, List<Integer> temp, Map<Integer, Integer> countMap) {
        if (nums.length == temp.size()) {
            results.add(new ArrayList<>(temp));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count != 0) {
                temp.add(num);
                countMap.put(num, count - 1);

                backtrack(nums, results, temp, countMap);

                temp.remove(temp.size() - 1);
                //restore the count for next backtrack processing.
                countMap.put(num, count);
            }
        }
    }


    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 2};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //[[1, 1, 2], [1, 2, 1], [2, 1, 1]]

    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 2};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //[[1, 1, 1, 2], [1, 1, 2, 1], [1, 2, 1, 1], [2, 1, 1, 1]]

    }

}
