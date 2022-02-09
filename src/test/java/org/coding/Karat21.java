package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/1393222/compass-online-interview-karat-snake-game
public class Karat21 {

    /*
    Snakes may now move in any of four directions - up, down, left, or right - one square at a time, but they will never return to a square that they've already visited.  If a snake enters the board on an edge square, we want to catch it at a different exit square on the board's edge.

    The snake is familiar with the board and will take the route to the nearest reachable exit, in terms of the number of squares it has to move through to get there. Note that there may not be a reachable exit.

    Here is an example board:

        col-->        0  1  2  3  4  5  6  7  8
                   +---------------------------
        row      0 |  +  +  +  +  +  +  +  0  0
         |       1 |  +  +  0  0  0  0  0  +  +
         |       2 |  0  0  0  0  0  +  +  0  +
         v       3 |  +  +  0  +  +  +  +  0  0
                 4 |  +  +  0  0  0  0  0  0  +
                 5 |  +  +  0  +  +  0  +  0  +

    Write a function that takes a rectangular board with only +'s and 0's,
    along with a starting point on the edge of the board,
    and returns the coordinates of the nearest exit to which it can travel.

    If there is a tie, return any of the nearest exits.
     */

    private int[] solution(char[][] grid, int[] start) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x >= 0 && x < grid.length
                        && y >= 0 && y < grid[x].length
                        && !visited[x][y]
                        && grid[x][y] == '0') {
                    if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1) {
                        return new int[]{x, y};
                    }
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test1() {
        char[][] grid = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}
        };
        System.out.println(Arrays.toString(solution(grid, new int[]{0, 3})));
    }

    @Test
    public void test2() {
        char[][] grid = {
                {'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                {'+', '+', '0', '+', '+', '0', '+', '0', '+'}
        };
        System.out.println(Arrays.toString(solution(grid, new int[]{2, 0})));// [5, 2]
        System.out.println(Arrays.toString(solution(grid, new int[]{0, 7})));// [0, 8]
        System.out.println(Arrays.toString(solution(grid, new int[]{5, 2})));// [2, 0] or [5, 5]
    }
}
