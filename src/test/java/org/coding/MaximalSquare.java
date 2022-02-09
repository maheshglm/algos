package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=6X7Ha2PrDmM
//https://leetcode.com/problems/maximal-square/
public class MaximalSquare {


    //Given an m x n binary matrix filled with 0's and 1's,
    //find the largest square containing only 1's and return its area.

    //bottom up and dynamic approach
    //recursive - top down
    private int solution(char[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Integer[][] memo = new Integer[rows][cols];

        helper(grid, memo, 0, 0);

        //now memo will get filled with result of each cell to form a square
        //
        int length = Integer.MIN_VALUE;
        for (Integer[] len : memo) {
            for (int j = 0; j < memo[0].length; j++) {
                length = Math.max(length, len[j]);
            }
        }
        return length * length;

    }

    private int helper(char[][] grid, Integer[][] memo, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        //base case - if row and col going out of bounds return 0, coz there is nothing in the outer cell
        if (row >= rows || col >= cols) {
            return 0;
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int downDir = helper(grid, memo, row + 1, col);
        int rightDir = helper(grid, memo, row, col + 1);
        int diagonalDir = helper(grid, memo, row + 1, col + 1);

        //initial value of max area or memo cell is zero
        memo[row][col] = 0;

        //if curr cell is also 1, then we add 1 for the result we need to add current 1 as well
        //hence adding 1 to the min result
        if (grid[row][col] == '1') {
            memo[row][col] = 1 + Math.min(downDir, Math.min(rightDir, diagonalDir));
        }
        return memo[row][col];
    }


    //https://www.youtube.com/watch?v=RElcqtFYTm0
    //using top down Dynamic Programming
    private int solution1(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxSqLen = 0;

        //formula iterate from 1 index (this is top down)
        //dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (grid[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                    maxSqLen = Math.max(maxSqLen, dp[i][j]);
                }
            }
        }
        return maxSqLen * maxSqLen;
    }

    @Test
    public void test1() {
        char[][] grid = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(solution(grid));
        System.out.println(solution1(grid));
        //output 4
    }
}
