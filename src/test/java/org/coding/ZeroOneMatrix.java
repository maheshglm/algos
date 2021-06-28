package org.coding;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/
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
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    q.add(new int[]{r, c});
                } else {
                    matrix[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : directions) {
                int row = cell[0] + dir[0];
                int col = cell[1] + dir[1];


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

        solution(matrix);

    }


}
