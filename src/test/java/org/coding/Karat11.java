package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1392828/Indeed-Karat-Interview
public class Karat11 {

    /*
    Given a position (x, y), return all the immediate neighbor coordinates that can be taken
    from the position without hitting -1 in all four directions.
    For example,
    (0, 0) -> [(0, 1), (1, 0)]
    (4, 0) -> [(5, 0)]
     */

    public List<int[]> solution(int[][] grid, int[] pos) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        List<int[]> result = new ArrayList<>();

        for (int[] dir : dirs) {
            int x = pos[0] + dir[0];
            int y = pos[1] + dir[1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != -1) {
                result.add(new int[]{x, y});
            }
        }
        return result;
    }

    /*
    Given a position (x, y), return if it is possible to start from any 0 in the grid and reach the position.
    For Example,
    ex: (4, 0) and (5, 0) are false as they blocked by -1 and so cannot reach (0, 0)
     */


    public boolean solution1(int[][] grid, int[] pos) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        dfs(grid, visited, pos);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int[][] grid, boolean[][] visited, int[] pos) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int x = pos[0];
        int y = pos[1];

        if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length
                && grid[x][y] != -1 && !visited[x][y]) {
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                dfs(grid, visited, new int[]{nx, ny});
            }
        }
    }


    private boolean solution2(int[][] grid, int[] pos) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length + 1][grid[0].length + 1];

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.add(pos);
        visited[pos[0]][pos[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[0] == 0 && curr[1] == 0) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length &&
                        !visited[x][y] && grid[x][y] != -1) {

                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }


    @Test
    public void test1() {
        int[][] grid = {
                {0, 0, 0, 0, -1},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
                {-1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0},
                {0, -1, 0, 0, 0},
        };

        solution(grid, new int[]{0, 0}).forEach(s -> System.out.print(Arrays.toString(s))); //[1,0] [0,1]
        System.out.println();
        solution(grid, new int[]{4, 0}).forEach(s -> System.out.print(Arrays.toString(s))); //5, 0
        System.out.println();


        System.out.println(solution2(grid, new int[]{4, 0}));
        System.out.println(solution2(grid, new int[]{5, 0}));
        System.out.println(solution2(grid, new int[]{0, 4}));
        System.out.println(solution2(grid, new int[]{5, 5}));

    }

}
