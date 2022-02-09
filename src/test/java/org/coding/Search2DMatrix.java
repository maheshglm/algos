package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=dHJDhsvBd8c&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=39
public class Search2DMatrix {

    //applying binary search as the matrix is sorted
    private boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //convert 2D array to 1D array so can apply
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1; //index in 1D

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int oneDRow = mid / rows;
            int oneDCol = mid % rows;

            if (matrix[oneDRow][oneDCol] == target) {
                return true;
            }
            if (matrix[oneDRow][oneDCol] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;

    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 3;

        System.out.println(solution(matrix, target));

        //Output = true;
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 13;

        //Output = false;
        System.out.println(solution(matrix, target));
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20}
        };

        int target = 11;

        //Output = true;
        System.out.println(solution(matrix, target));
    }


}
