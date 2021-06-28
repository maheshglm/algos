package org.coding;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=sA4QuOnE_Dw
//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInBinaryMatrix {

    /*
    Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

    A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
    The length of a clear path is the number of visited cells of this path
     */

    int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        if (n == 1) return 1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        //visited array can be ignored by assigning grid[i][i] = 1 (non zero)
        //visited[0][0] = true;
        grid[0][0] = 1;
        int distance = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return distance + 1;
                }

                for (int[] dir : direction) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];

//                    if (x >= 0 && x < n && y >= 0 && y < n
//                            && !visited[x][y] && grid[x][y] == 0) {
                    if (x >= 0 && x < n && y >= 0 && y < n
                            && grid[x][y] == 0) {
                        q.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
            distance++;

        }
        return -1;
    }


    //different implementation
    public int solution1(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int n = grid.length;

        if (n == 1) return 1;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        //adding 2nd index for distance
        q.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return curr[2] + 1;
            }

            for (int[] dir : direction) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];

                if (isInside(x, y, n) && !visited[x][y] &&
                        grid[x][y] != 1) {
                    q.add(new int[]{x, y, curr[2] + 1});
                    visited[x][y] = true;
                }
            }
        }

        return -1;

    }

    private boolean isInside(int x, int y, int size) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }


    @Test
    public void test1() {
        int[][] grid = {
                {0, 1},
                {1, 0}
        };
        //System.out.println(solution(grid));
        System.out.println(solution1(grid));

        //Ans: 2
    }

    @Test
    public void test2() {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        //System.out.println(solution(grid));
        System.out.println(solution1(grid));
        //Ans: 4
    }

    @Test
    public void test3() {
        int[][] grid = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        //System.out.println(solution(grid));
        System.out.println(solution1(grid));
        //Ans: -1
    }


}
