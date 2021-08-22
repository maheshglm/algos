package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII {

    private int[][] solution(int n) {

        int[][] result = new int[n][n];
        int value = 1;

        if (n == 1) {
            result[0][0] = value;
            return result;
        }

        int rowBegin = 0;
        int rowEnd = n - 1;

        int colBegin = 0;
        int colEnd = n - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = value++;
            }

            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = value++;
            }

            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result[rowEnd][i] = value++;
                }
            }

            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[i][colBegin] = value++;
                }
            }
            colBegin++;
        }
        return result;

    }


    @Test
    public void test1() {
        int n = 3;
        //output {
        //          {1,2,3}
        //          {8,9,4}
        //          {7,6,5}

        System.out.println(Arrays.deepToString(solution(n)));
    }

}
