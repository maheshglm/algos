package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/
//https://www.youtube.com/watch?v=UWykmfK7ta4
public class ZeroOneMatrix {

    /*
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
     */
    private int[][] solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        //add zero cells to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] currentPosition = q.poll();
                for (int[] dir : directions) {
                    int row = currentPosition[0] + dir[0];
                    int col = currentPosition[1] + dir[1];

                    if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col])
                        continue;

                    //else
                    matrix[row][col] = matrix[currentPosition[0]][currentPosition[1]] + 1;
                    q.add(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        return matrix;
    }


    @Test
    public void test1() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] output = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(Arrays.deepToString(solution(matrix)));

    }

    @Test
    public void test2() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] output = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };

        System.out.println(Arrays.deepToString(solution(matrix)));

    }


}
