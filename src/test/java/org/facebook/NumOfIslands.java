package org.facebook;

import org.junit.Test;

public class NumOfIslands {

    private static int solution(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        callBFS(grid, i + 1, j);
        callBFS(grid, i - 1, j);
        callBFS(grid, i, j + 1);
        callBFS(grid, i, j - 1);
    }

    @Test
    public void test1() {
        char[][] grid =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };

        System.out.println(solution(grid));
    }

    @Test
    public void test2() {
        char[][] grid =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };

        System.out.println(solution(grid));

    }
}
