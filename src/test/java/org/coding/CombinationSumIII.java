package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.educative.io/m/find-all-sum-combinations
public class CombinationSumIII {

    private List<List<Integer>> solution(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, 0, 1, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int n, int current_sum, int index, List<Integer> tempList, List<List<Integer>> result) {
        if (current_sum == n) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = index; i < n; i++) {
            int tempSum = current_sum + i;
            if (tempSum <= n) {
                tempList.add(i);
                dfs(n, tempSum, i, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    @Test
    public void test1() {
        int n = 4;
        List<List<Integer>> solution = solution(n);
        System.out.println(solution);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2, 2));
        expected.add(Arrays.asList(1, 1, 2));
        expected.add(Arrays.asList(1, 1, 1, 1));

        Assert.assertTrue(solution.size() == expected.size()
                && solution.containsAll(expected)
                && expected.containsAll(solution));
    }
}
