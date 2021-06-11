package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=3joo9yAZVh8
//https://www.techiedelight.com/print-matrix-spiral-order/
public class SpiralMatrix {

    private List<Integer> solution(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            //print row as per rowBegin index value
            for (int i = columnBegin; i <= columnEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            //print column as per columnEnd index value
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][columnEnd]);
            }

            columnEnd--;

            //since we incremented rowBegin above, we need to check
            //are we still in boundaries
            //then print row as per rowEnd index value
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            //since we decremented columnEnd above, we need to check
            //are we still in boundaries
            //then print column as per colBegin index values
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;
        }
        return list;
    }


    @Test
    public void test1() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        System.out.println(solution(matrix));
        //output - 1 2 3 4 5 6 7 8 9 10 11 12 13
        //14 15 16 17 18 19 20 21 22 23 24 25

    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(solution(matrix));
        //output - 1,2,3,4,8,12,11,10,9,5,6,7
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {7},
                {9},
                {6}
        };

        System.out.println(solution(matrix));
        //output - 7 9 6
    }

}
