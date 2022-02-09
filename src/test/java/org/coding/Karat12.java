package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/discuss/interview-question/872735/roblox-karat-interview
public class Karat12 {

    /*
    Find the top left and bottom right coordinates of a rectangle of 0's within a matrix of 1's.
    It's essentially a modified version of the finding the number of island problem where you only
    need to dfs to the right and down.
     */

    private List<List<Integer>> solution(int[][] grid) {

        if (grid == null || grid.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    result.add(Arrays.asList(i, j));
                    int[] end = new int[2];
                    dfs(grid, i, j, end);
                    result.add(Arrays.asList(end[0], end[1]));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j, int[] end) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 0) {
            end[0] = Math.max(end[0], i);
            end[1] = Math.max(end[1], j);
            grid[i][j] = 1;
            dfs(grid, i + 1, j, end);
            dfs(grid, i - 1, j, end);
            dfs(grid, i, j + 1, end);
            dfs(grid, i, j - 1, end);
        }
    }


    @Test
    public void test1() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3));
        List<List<Integer>> actual = solution(matrix);
        Assert.assertTrue(expected.containsAll(actual));

        System.out.println(actual);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 1), Arrays.asList(2, 2));
        List<List<Integer>> actual = solution(matrix);
        Assert.assertTrue(expected.containsAll(actual));
    }

    @Test
    public void test3() {

        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 1, 1}
        };

        List<List<Integer>> actual = solution(matrix);
        System.out.println(actual);
    }


}
