package org.facebook;


import org.junit.Test;

//https://www.youtube.com/watch?v=Ohke9-qwAKU&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=40
public class Search2DMatrixII {

    private boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    @Test
    public void tes1() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };

        int target = 5;
        //true;
        System.out.println(solution(matrix, target));

    }

    @Test
    public void tes2() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };

        int target = 25;
        //false;
        System.out.println(solution(matrix, target));

    }
}
