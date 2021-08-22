package org.coding;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-to-get-food/
public class ShortestPathToGetFood {

    //solved
    private int solution(char[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '*') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 'X') {
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] myLocation = q.poll();
                if (grid[myLocation[0]][myLocation[1]] == '#') {
                    return length;
                }

                for (int[] dir : directions) {
                    int x = myLocation[0] + dir[0];
                    int y = myLocation[1] + dir[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y])
                        continue;

                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            length++;
        }
        return -1;
    }


}
